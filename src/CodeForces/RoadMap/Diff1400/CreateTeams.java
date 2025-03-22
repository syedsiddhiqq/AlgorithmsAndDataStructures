package CodeForces.RoadMap.Diff1400;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 25-05-2022, Wednesday, 10:07
 */
public class CreateTeams {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt(), x = s.nextInt();

        int[] arr = new int[n];
        TreeMap<Long, Long> freq = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
            long rem = x % arr[i];
            long div = rem == 0 ? x / arr[i] : x / arr[i] + 1;

            freq.put(div, freq.getOrDefault(div, 0L) + 1);
        }

        long prev = 0, ans = Long.MIN_VALUE;
        for (Long key : freq.keySet()) {
            long count = freq.get(key);
            prev += count;
            ans = Math.max(ans, prev / key);
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
