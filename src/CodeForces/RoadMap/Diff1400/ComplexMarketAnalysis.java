package CodeForces.RoadMap.Diff1400;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 30-04-2022, Saturday, 10:52
 */
public class ComplexMarketAnalysis {
    private static Scanner s = new Scanner(System.in);


    private static boolean isPrime(int number) {
        if (number < 2) return true;
        if (number % 2 == 0) return (number == 2);
        int root = (int) Math.sqrt((double) number);
        for (int i = 3; i <= root; i += 2) {
            if (number % i == 0) return false;
        }
        return true;
    }

    private static void solve() {
        int n = s.nextInt(), e = s.nextInt();

        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];


        for (int i = 1; i <= n; i++) {
            arr[i] = s.nextInt();
            if (i - e >= 1 && isPrime(arr[i])) {
                int temp = arr[i] * arr[i - e];
                if (temp > 1 && isPrime(temp)) {
                    dp[i]++;
                    dp[i] += dp[i - e];
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += dp[i];
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
