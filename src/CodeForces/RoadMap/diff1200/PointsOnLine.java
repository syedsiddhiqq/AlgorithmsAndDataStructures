package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli jfs
 * @createdAt 07-04-2022, Thursday, 22:27
 */
public class PointsOnLine {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        long d = s.nextLong();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextLong();
        }

        long count = 0;

        int r = 0;
        for (int l = 0; l < n; l++) {
            while (r + 1 < n && arr[r + 1] - arr[l] <= d) {
                r++;
            }
            long points = r - l;
            if (points >= 2) {
                count += (points - 1) * points / 2;
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        solve();
    }
}
