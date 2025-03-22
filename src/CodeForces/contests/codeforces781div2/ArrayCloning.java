package CodeForces.contests.codeforces781div2;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 08-04-2022, Friday, 20:26
 */
public class ArrayCloning {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        long[] arr = new long[n];

        Map<Long, Integer> freq = new HashMap<>();

        long maxFreq = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextLong();
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
            if (maxFreq < freq.get(arr[i])) {
                maxFreq = freq.get(arr[i]);
            }
        }

        long remaining = n - maxFreq, operations = 0;
        while (remaining > 0) {
            // for cloning.
            operations = operations + 1;

            long freqAfterCloning = maxFreq;
            operations += Math.min(remaining, freqAfterCloning);
            remaining -= freqAfterCloning;
            maxFreq += freqAfterCloning;
        }
        System.out.println(operations);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
