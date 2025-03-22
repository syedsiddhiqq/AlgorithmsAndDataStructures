package LeetCode.dp;

public class CountSquares {

    public static int countSquares(int n, int m, int[][] arr) {
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = arr[i][j];
                } else if (dp[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }

        int squares = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                squares += dp[i][j];
            }
        }
        return squares;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 0},
                {0, 1}
        };

        System.out.println(countSquares(2, 2, mat));
    }
}
