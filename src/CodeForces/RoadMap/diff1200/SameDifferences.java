package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 15-03-2022, Tuesday, 19:47
 */
public class SameDifferences {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        long[] arr = new long[n + 1];

        Map<Long, Long> freq = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            arr[i] = s.nextLong();
            arr[i] = Long.valueOf(arr[i] - i);

            if (freq.containsKey(arr[i])) {
                freq.put(arr[i], freq.get(arr[i]) + 1);
            } else {
                freq.put(arr[i], Long.valueOf(1));
            }
        }

        long ans = 0;
        for (long value : freq.values()) {
            ans+= (value * (value - 1)/2);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}


/*
16
1 2  3  4  5  6  7  8  9  10 11 12 13 14 15 16
9 13 11 15 13 16 16 11 15 15 16 16 16 16 15 16
*/