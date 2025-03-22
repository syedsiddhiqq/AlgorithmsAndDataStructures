package LeetCode.dp;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 13-10-2022, Thursday, 06:23
 */
public class ShortestCommonSubsequence {

    private static String findLcs(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        String[][] dp = new String[str1.length + 1][str2.length + 1];

        for (int i = 0; i <= str1.length; i++) {
            for (int j = 0; j <= str2.length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = "";
                } else if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + str1[i - 1];
                } else {
                    dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ? dp[i - 1][j] : dp[i][j - 1];
                }
            }
        }
        return dp[str1.length][str2.length];
    }

    public static void main(String[] args) {
        String s1 = "abac";
        String s2 = "cab";

        String s3 = findLcs(s1, s2);
        int a, b, c;
        a = b = c = 0;

        String ans = "";
        for (int i = 0; i < s3.length(); i++) {
            char ch = s3.charAt(i);

            while (a < s1.length() && s1.charAt(a) != ch) {
                ans += s1.charAt(a);
                a++;
            }
            while (b < s2.length() && s2.charAt(b) != ch) {
                ans += s2.charAt(b);
                b++;
            }
            ans += ch;
            a++;
            b++;
        }
        System.out.println(ans + s1.substring(a) + s2.substring(b));
    }
}
