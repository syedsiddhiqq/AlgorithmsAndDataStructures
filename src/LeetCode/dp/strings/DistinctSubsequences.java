package LeetCode.dp.strings;

import java.util.Arrays;

public class DistinctSubsequences {

    public static int distinctSubsequences(String str, String sub) {
        int n = str.length(), m = sub.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int i=0;i<=n;i++) dp[i][0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(str.charAt(i - 1) == sub.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }
    public static int distinctSubsequencesMemoization(String str, String sub) {
        int n = str.length(), m = sub.length();
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(dp[i], -1);
        return f(str, sub, n - 1, m - 1, dp);
    }

    private static int f(String str, String sub, int i, int j, int[][] dp){
        if(j < 0) return 1;
        if(i < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(str.charAt(i) == sub.charAt(j)){
            return f(str, sub, i - 1, j - 1, dp) + f(str, sub, i - 1, j, dp);
        }else{
            return f(str, sub, i - 1, j, dp);
        }
    }

    public static void main(String[] args) {
        System.out.println(distinctSubsequences("brootgroot", "brt"));
    }
}
