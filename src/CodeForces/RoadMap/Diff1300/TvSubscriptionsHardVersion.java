package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 22-04-2022, Friday, 09:56
 */
public class TvSubscriptionsHardVersion {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt(), k = s.nextInt(), d = s.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = s.nextInt();

        int a = 1, b = d;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < d; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int ans = map.keySet().size();
        while (a <= b && b < n) {
            if (map.containsKey(arr[a - 1])) {
                int count = map.get(arr[a - 1]) - 1;
                if (count == 0) {
                    map.remove(arr[a - 1]);
                } else {
                    map.put(arr[a - 1], count);
                }
            }

            map.put(arr[b], map.getOrDefault(arr[b], 0) + 1);
            a++;
            b++;
            ans = Math.min(ans, map.size());
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
