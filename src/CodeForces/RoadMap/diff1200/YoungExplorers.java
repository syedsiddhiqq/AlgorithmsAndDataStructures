package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 17-03-2022, Thursday, 10:10
 */
public class YoungExplorers {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        int[] arr = new int[n];

        Map<Integer, Integer> freq = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
            if (freq.containsKey(arr[i])) {
                freq.put(arr[i], freq.get(arr[i]) + 1);
            } else {
                freq.put(arr[i], 1);
            }
        }

        int ans = 0, remaining = 0;
        for (Integer key : freq.keySet()) {
            int count = freq.get(key);
            if (count < key) {
                ans += (remaining + count) / key;
                remaining = (remaining + count) % key;
            } else {
                ans += count / key;
                int remCount = ((count % key) + remaining);
                ans += remCount / key;
                remaining = remCount % key;
            }
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
