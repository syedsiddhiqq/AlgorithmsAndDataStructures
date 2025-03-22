package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 11-04-2022, Monday, 08:29
 */
public class SlayTheDragon {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        Long[] arr = new Long[n];

        long sum = 0;

        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextLong();
            sum += arr[i];
            set.add(arr[i]);
        }

        int m = s.nextInt();
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            long ans = Long.MAX_VALUE;
            long x = s.nextLong(), y = s.nextLong();
            Long floorKey = set.floor(x);
            Long ceilingKey = set.ceiling(x);
            floorKey = floorKey == null ? set.first() : floorKey;
            ceilingKey = ceilingKey == null ? set.last() : ceilingKey;
            ans = Math.min(ans, Math.max(0, x - floorKey) + Math.max(0, y - (sum - floorKey)));
            ans = Math.min(ans, Math.max(0, x - ceilingKey) + Math.max(0, y - (sum - ceilingKey)));
            sb.append(ans + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        solve();
        s.close();
    }
}
