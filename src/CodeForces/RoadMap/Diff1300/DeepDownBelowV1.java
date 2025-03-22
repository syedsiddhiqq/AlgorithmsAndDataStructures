//package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 11-04-2022, Monday, 10:06
 */
public class DeepDownBelowV1 {
    private static Scanner s = new Scanner(System.in);

    private static boolean check(Long[] cave, long power) {
        for (int i = 0; i < cave.length; i++) {
            if (cave[i] < power) {
                power++;
            } else {
                return false;
            }
        }
        return true;
    }

    private static long findMinPower(Long[] cave) {
        Arrays.sort(cave);
        long ans = Long.MAX_VALUE;
        int low = 0, high = (int) 1e9;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (check(cave, mid)) {
                ans = Math.min(ans, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static void solve() {
        int n = s.nextInt();
        List<Long[]> caves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int k = s.nextInt();
            Long[] cave = new Long[k];
            for (int j = 0; j < k; j++) {
                cave[j] = s.nextLong();
            }

            caves.add(cave);
        }

        Long[] finalCavePowers = new Long[n];
        for (int i = 0; i < caves.size(); i++) {
            long power = findMinPower(caves.get(i));
            finalCavePowers[i] = power;
        }
        System.out.println(findMinPower(finalCavePowers) - 1);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
