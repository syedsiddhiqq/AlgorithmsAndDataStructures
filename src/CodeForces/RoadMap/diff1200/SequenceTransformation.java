//package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 18-03-2022, Friday, 14:37
 */
public class SequenceTransformation {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        long[] arr = new long[n];


        Map<Long, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextLong();
            if (i == 0 || arr[i] != arr[i - 1]) {
                if (freq.containsKey(arr[i])) {
                    freq.put(arr[i], freq.get(arr[i]) + 1);
                } else {
                    freq.put(arr[i], 1);
                }
            }
        }

        long ans = Long.MAX_VALUE;
        for (Long key : freq.keySet()) {
            int count = freq.get(key) + 1;
            if (arr[0] == key) count--;
            if (arr[n - 1] == key) count--;
            ans = Math.min(count, ans);
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
