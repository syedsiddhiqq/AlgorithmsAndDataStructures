package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 05-04-2022, Tuesday, 08:56
 */
public class BooksExchange {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = s.nextInt();
        }

        int[] count = new int[n + 1];
        Map<String, Integer> cache = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            if (count[i] == 0) {
                int h = dfs(arr[i], i, arr, 1, cache);
                count[i] = h;
                if (count[arr[i]] == 0) count[arr[i]] = h;
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(count[i] + " ");
        }
        System.out.println();
    }

    private static int dfs(int start, int target, int[] arr, int h, Map<String, Integer> cache) {
        String key = start + "," + target;
        if (cache.containsKey(key)) return cache.get(key);
        if (start == target) return h;
        cache.put(key, dfs(arr[start], target, arr, h + 1, cache));
        return cache.get(key);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
