package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 14-04-2022, Thursday, 11:18
 */
public class Years {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        Map<Long, Long> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            long birth = s.nextLong(), death = s.nextLong();
            map.put(birth, map.getOrDefault(birth, 0L) + 1);
            map.put(death, map.getOrDefault(death, 0L) - 1);
        }

        long alive = 0, maxAlive = Long.MIN_VALUE, year = -1;
        for (Long currYear : map.keySet()) {
            alive += map.get(currYear);
            if (maxAlive < alive) {
                maxAlive = alive;
                year = currYear;
            }
        }
        System.out.println(year + " " + maxAlive);
    }

    public static void main(String[] args) {
        solve();
        s.close();
    }
}
