package LeetCode.dp.strings;

import java.util.Arrays;

public class WildCardMatching {

    public static boolean wildcardMatching(String pattern, String text) {
        int n = pattern.length(), m = text.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (pattern.charAt(i - 1) != '*') break;
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (pattern.charAt(i - 1) == text.charAt(j - 1) || pattern.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[n][m];
    }

    public static boolean wildcardMatchingMemoization(String pattern, String text) {
        int n = pattern.length(), m = text.length();
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        return f(pattern, text, pattern.length() - 1, text.length() - 1, dp);
    }

    private static boolean f(String pattern, String text, int i, int j, int[][] dp) {
        if (i < 0 && j < 0) return true;
        if (i < 0 && j >= 0) return false;
        if (j < 0 && i >= 0) {
            for (int ii = 0; ii <= i; ii++) {
                if (pattern.charAt(ii) != '*') return false;
            }
            return true;
        }
        if (dp[i][j] != -1) return dp[i][j] == 1;
        // If String matches or if wildcard is present '?'
        if (pattern.charAt(i) == text.charAt(j) || pattern.charAt(i) == '?') {
            boolean matched = f(pattern, text, i - 1, j - 1, dp);
            dp[i][j] = matched ? 1 : 0;
            return matched;
        } else if (pattern.charAt(i) == '*') {
            // If pattern contains '*' -> It can match a sequence
            // Possibilities -> Take * -> For j or Add one more char for j
            boolean notMatched = f(pattern, text, i - 1, j, dp) || f(pattern, text, i, j - 1, dp);
            dp[i][j] = notMatched ? 1 : 0;
            return notMatched;
        }
        dp[i][j] = 0;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(wildcardMatching("?ay", "ray"));
        System.out.println(wildcardMatching("ab*cd", "abdefcd"));
        System.out.println(wildcardMatching("ab?d", "abcc"));
    }
}
