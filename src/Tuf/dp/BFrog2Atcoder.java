package Tuf.dp;

import java.util.Scanner;

/**
 * https://atcoder.jp/contests/dp/tasks/dp_b
 */
public class BFrog2Atcoder {

    private static int frogJump2(int[] arr, int n, int k) {
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            int energy = Integer.MAX_VALUE;
            for (int itr = 1; itr <= k; itr++) {
                if (i - itr >= 0) {
                    energy = Math.min(energy, dp[i - itr] + Math.abs(arr[i] - arr[i - itr]));
                }
            }
            dp[i] = energy;
        }
        return dp[n - 1];
    }

    private static int frogJump2Util(int[] arr, int i, int k) {
        if (i <= 0) return 0;
        int energy = Integer.MAX_VALUE;
        for (int itr = 1; itr <= k; itr++) {
            if (i - itr >= 0) {
                energy = Math.min(energy, frogJump2Util(arr, i - itr, k) + Math.abs(arr[i] - arr[i - itr]));
            }
        }
        return energy;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(frogJump2(arr, n, k));
    }
}
