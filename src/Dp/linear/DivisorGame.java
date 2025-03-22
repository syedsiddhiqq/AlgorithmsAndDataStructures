package Dp.linear;

import java.util.Map;

/**
 * https://leetcode.com/problems/divisor-game/description/
 */
public class DivisorGame {
    public static boolean divisorGame(int n) {
        boolean[][] dp = new boolean[2][n + 1];
        for(int i=2; i<=n; i++){
            for(int j=0;j<2;j++){
                if(i == 2){
                    dp[j][i] = true;
                }else{
                    boolean right = false, left = false;
                    if(i % 2 == 0 && (i / 2 ) % 2 != 0){
                        right = dp[j][i - i/2];
                    }else{
                        left = dp[j][i - 1];
                    }
                    dp[j][i] = right || left;
                }
            }
        }
        return dp[0][n];
    }

    private boolean dfs(int i, boolean alice, Map<String, Boolean> cache){
        String key = i + ","+ alice;
        if(cache.containsKey(key)) return cache.get(key);
        if(i == 1) return !alice;
        if(i == 2) return alice;
        boolean right = false, left = false;
        if(i % 2 == 0 && (i / 2 ) % 2 != 0){
            right = dfs(i - i / 2, !alice, cache);
        }else{
            left = dfs(i - 1, !alice, cache);
        }
        cache.put(key, left || right);
        return left || right;
    }

    public static void main(String[] args) {
        System.out.println(divisorGame(3));
    }
}
