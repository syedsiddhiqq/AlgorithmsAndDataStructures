package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestStringChain {

    public static int longestStrChain(String[] arr) {
        int n = arr.length;
        Arrays.sort(arr, Comparator.comparingInt(String::length));
        int[] dp = new int[n], hash = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 0; i < n; i++) {
            hash[i] = i;
            for (int j = 0; j < i; j++) {
                if (check(arr[i], arr[j])) {
                    if (dp[i] <= 1 + dp[j]) {
                        dp[i] = 1 + dp[j];
                        hash[i] = j;
                    }
                }
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    public static int longestStrChainRecursion(String[] arr) {
        Arrays.sort(arr, Comparator.comparingInt(String::length));
        int n = arr.length;
        return f(arr, 0, -1, n);
    }

    private static int f(String[] arr, int i, int prev, int n) {
        if (i == n) return 0;
        int count = f(arr, i + 1, prev, n);
        if (prev == -1 || check(arr[i], arr[prev])) {
            count = Math.max(count, 1 + f(arr, i + 1, i, n));
        }
        return count;
    }

    private static boolean check(String a, String b) {
        if (a.length() != b.length() + 1) return false;
        int first = 0, second = 0;
        while (first < a.length()) {
            if (second < b.length() && a.charAt(first) == b.charAt(second)) {
                first++;
                second++;
            } else {
                first++;
            }
        }
        return first == a.length() && second == b.length();
    }

    public static void main(String[] args) {
        String[] arr = {"a", "bc", "ad", "adc"};
        System.out.println(longestStrChain(arr));
    }
}
