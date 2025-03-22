package LeetCode.dp;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 10-10-2022, Monday, 17:48
 */
public class RodCuttingProblem {

    private static Integer maxProfit(int[] prices, int[] input, int length){
        int arrLength = prices.length;
        int[][] dp = new int[arrLength + 1][length + 1];

        for(int i=0;i<=arrLength;i++){
            for(int j=0;j<=length;j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }else if(input[i-1] > j){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], prices[i - 1] + dp[i][j - input[i - 1]]);
                }
            }
        }
        return dp[arrLength][length];
    }

    public static void main(String[] args) {
        int[] prices = {1,5,8,3},lengthArr= {1,2,3,4};
        int length = 4;
        System.out.println(maxProfit(prices,lengthArr,length));
    }
}
