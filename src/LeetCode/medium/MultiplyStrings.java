package LeetCode.medium;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 16-04-2022, Saturday, 14:50
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        if (num1.length() < num2.length()) return multiply(num2, num1);
        int zeroes = 0;
        String prev = null;
        for (int i = num2.length() - 1; i >= 0; i--) {
            int a = ctoi(num2.charAt(i));
            int rem = 0;
            StringBuilder sb = new StringBuilder();
            for (int zero = 0; zero < zeroes; zero++) sb.append("0");
            for (int j = num1.length() - 1; j >= 0; j--) {
                int b = ctoi(num1.charAt(j));
                int temp = a * b + rem;
                if (j != 0) {
                    sb.append(temp % 10);
                    rem = temp / 10;
                } else {
                    sb.append(temp % 10);
                    rem = temp / 10;
                    if (rem > 0) sb.append(rem);
                }
            }
            if (prev == null) {
                prev = sb.reverse().toString();
            } else {
                prev = add(prev, sb.reverse().toString());
            }
            zeroes++;
        }
        return prev;
    }

    private String add(String s1, String s2) {
        int rem = 0;
        StringBuilder sb = new StringBuilder();
        int aStart = s1.length() - 1, bStart = s2.length() - 1;
        while (aStart >= 0 && bStart >= 0) {
            int temp = rem + ctoi(s1.charAt(aStart--)) + ctoi(s2.charAt(bStart--));
            sb.append(temp % 10);
            rem = temp / 10;
        }

        if (aStart < 0 && bStart < 0 && rem > 0) {
            sb.append(rem);
            rem = 0;
        }

        while (aStart >= 0) {
            int temp = rem + ctoi(s1.charAt(aStart--));
            sb.append(temp % 10);
            rem = temp / 10;
        }

        while (bStart >= 0) {
            int temp = rem + ctoi(s2.charAt(bStart--));
            sb.append(temp % 10);
            rem = temp / 10;
        }

        if (rem > 0) sb.append(rem);
        return sb.reverse().toString();
    }

    private int ctoi(char ch) {
        return ch - '0';
    }

    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply("9", "9"));
    }
}
