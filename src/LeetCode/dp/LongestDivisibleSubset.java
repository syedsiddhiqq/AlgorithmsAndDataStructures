package LeetCode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestDivisibleSubset {

    public static List<Integer> divisibleSetGreedyTabulation(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int[] dp = new int[n], hash = new int[n];
        Arrays.fill(dp, 1);
        int max = 1, lastIndex = 0;
        for (int i = 0; i < n; i++) {
            hash[i] = i;
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    if (dp[i] <= 1 + dp[j]) {
                        dp[i] = 1 + dp[j];
                        hash[i] = j;
                    }
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                lastIndex = i;
            }
        }
        List<Integer> result = new ArrayList<>();
        result.add(arr[lastIndex]);
        while(hash[lastIndex] != lastIndex){
            lastIndex = hash[lastIndex];
            result.add(arr[lastIndex]);
        }
//        for (int i = 0; i < n; i++) {
//            System.out.println("hash[" + i + "] :: " + hash[i]);
//        }
        return result;
    }

    public static List<Integer> divisibleSet(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int[] after = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int[] curr = new int[n + 1];
            for (int prev = i - 1; prev >= -1; prev--) {
                curr[i] = after[prev + 1];
                if (prev == -1 || arr[i] % arr[prev] == 0) {
                    curr[i] = Math.max(curr[i], 1 + after[i + 1]);
                }
            }
            after = curr;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 8, 16};
        int[] arr2 = {16, 1, 1, 18, 24};
        int[] arr3 = {20, 19, 11, 25, 21};
        System.out.println(divisibleSetGreedyTabulation(arr3));
    }
}
