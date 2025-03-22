package LeetCode.medium;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 14-04-2022, Thursday, 13:14
 */
public class LetterCombination {
    public static List<String> letterCombinations(String digits) {
        String[] values = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz", ""};
        List<String> numbers = new ArrayList<>();

        for (int i = 0; i < digits.length(); i++) {
            numbers.add(values[Integer.parseInt(String.valueOf(digits.charAt(i)))]);
        }

        List<String> result = new ArrayList<>();
        if (numbers.size() > 0) {
            String a = numbers.get(0);
            for (int i = 0; i < a.length(); i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(a.charAt(i));

                if (numbers.size() > 1) {
                    String b = numbers.get(1);
                    for (int j = 0; j < b.length(); j++) {
                        sb.append(b.charAt(j));

                        if (numbers.size() > 2) {
                            String c = numbers.get(2);
                            for (int k = 0; k < c.length(); k++) {
                                sb.append(c.charAt(k));

                                if (numbers.size() > 3) {
                                    String d = numbers.get(3);
                                    for (int l = 0; l < d.length(); l++) {
                                        sb.append(d.charAt(l));
                                        if (sb.length() == numbers.size()) {
                                            result.add(sb.toString());
                                            sb = new StringBuilder();
                                            sb.append(a.charAt(i));
                                            sb.append(b.charAt(j));
                                            sb.append(c.charAt(k));
                                        }
                                    }
                                    sb = new StringBuilder();
                                    sb.append(a.charAt(i));
                                    sb.append(b.charAt(j));
                                }
                                if (sb.length() == numbers.size()) {
                                    result.add(sb.toString());
                                    sb = new StringBuilder();
                                    sb.append(a.charAt(i));
                                    sb.append(b.charAt(j));
                                }
                            }
                            sb = new StringBuilder();
                            sb.append(a.charAt(i));
                        }
                        if (sb.length() == numbers.size()) {
                            result.add(sb.toString());
                            sb = new StringBuilder();
                            sb.append(a.charAt(i));
                        }
                    }
                }
                if (sb.length() == numbers.size()) {
                    result.add(sb.toString());
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("5678"));
    }
}
