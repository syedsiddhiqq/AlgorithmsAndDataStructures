package LeetCode.dp.strings;

import java.util.Arrays;

public class EditDistances {

    public static int editDistance(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int[] prev = new int[m + 1];
        for (int j = 0; j <= m; j++) prev[j] = j;

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            curr[0] = i;
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    int insert = curr[j - 1];
                    int delete = prev[j];
                    int replace = prev[j - 1];
                    curr[j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
            prev = curr;
        }
        return prev[m];
    }

    public static int editDistanceDP(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = i;
        for (int j = 0; j <= m; j++) dp[0][j] = j;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = dp[i][j - 1];
                    int delete = dp[i - 1][j];
                    int replace = dp[i - 1][j - 1];
                    dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return dp[n][m];
    }

    public static int editDistanceMemoization(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        return f(str1, str2, str1.length() - 1, str2.length() - 1, dp);
    }

    private static int f(String a, String b, int i, int j, int[][] dp) {
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;
        if (dp[i][j] != -1) return dp[i][j];
        if (a.charAt(i) == b.charAt(j)) {
            return dp[i][j] = f(a, b, i - 1, j - 1, dp);
        } else {
            int insert = f(a, b, i, j - 1, dp);
            int delete = f(a, b, i - 1, j, dp);
            int replace = f(a, b, i - 1, j - 1, dp);
            return dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
        }
    }

    public static void main(String[] args) {
        System.out.println(editDistance("acdefgd", "aawdfg"));
    }
}
