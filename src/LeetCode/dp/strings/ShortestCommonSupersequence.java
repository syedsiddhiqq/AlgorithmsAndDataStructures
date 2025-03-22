package LeetCode.dp.strings;

public class ShortestCommonSupersequence {

    public static String shortestSupersequence(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        int i = n, j = m;
        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) {
            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                sb.append(s.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    sb.append(s.charAt(i - 1));
                    i--;
                } else {
                    sb.append(t.charAt(j - 1));
                    j--;
                }
            }
        }

        while (i > 0) {
            sb.append(s.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            sb.append(t.charAt(j - 1));
            j--;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(shortestSupersequence("brute", "groot"));
    }
}
