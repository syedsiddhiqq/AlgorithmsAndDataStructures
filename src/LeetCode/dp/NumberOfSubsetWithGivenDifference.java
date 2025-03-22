package LeetCode.dp;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 07-10-2022, Friday, 17:43
 */
public class NumberOfSubsetWithGivenDifference {

    private static Integer countNumberOfSubsetsWithGivenDifference(int[] arr, int diff){
        int sum = Arrays.stream(arr).sum();
        sum = (diff + sum)/2;
        int[][] dp = new int[arr.length+1][sum+1];

        for(int i=0;i<=arr.length;i++){
            for(int j=0;j<=sum;j++){
                if(j == 0){
                    dp[i][j] = 1;
                }else if(i == 0){
                    dp[i][j] = 0;
                }else if(arr[i - 1] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i-1][j - arr[i-1]];
                }
            }
        }
        return dp[arr.length][sum];
    }

    public static void main(String[] args) {
        int[] arr = {3,1,2,3};
        int diff = 3;
        System.out.println(countNumberOfSubsetsWithGivenDifference(arr, diff));
    }
}
