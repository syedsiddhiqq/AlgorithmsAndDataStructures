package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 18-03-2022, Friday, 09:45
 */
public class MaximumProduct {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextLong();
        }

        Arrays.sort(arr);

        // n == 5 and 3 +ve and 2 -ve case.
        long ans = Math.max(Long.MIN_VALUE, arr[n - 1] * arr[n - 2] * arr[n - 3] * arr[0] * arr[1]);

        // 5 positive case
        ans = Math.max(ans, arr[n - 1] * arr[n - 2] * arr[n - 3] * arr[n - 4] * arr[n - 5]);

        // 4 -ve and 1 positive case.
        ans = Math.max(ans, arr[0] * arr[1] * arr[2] * arr[3] * arr[n - 1]);

        System.out.println(ans);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
