package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 12-04-2022, Tuesday, 21:41
 */
public class LittleAlawn {
    private static Scanner s = new Scanner(System.in);

    private static long mod = (long) 1e9 + 7;

    private static void solve() {
        int n = s.nextInt();
        long[][] grid = new long[2][n];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = s.nextLong();
            }
        }

        if (n == 2) {
            System.out.println(2);
            return;
        }

        int totalCount = 0;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(grid[1][i])) {
                if (map.get(grid[1][i]) == grid[0][i]) totalCount++;
            } else {
                map.put(grid[0][i], grid[1][i]);
            }
        }

        long total = 1;
        for(int i = 0; i <= totalCount; i++){
            total = total * 2 % 1000000007;
        }
        System.out.println(total);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
