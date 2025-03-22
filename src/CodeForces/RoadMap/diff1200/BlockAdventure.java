package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 31-03-2022, Thursday, 09:34
 */
public class BlockAdventure {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt(), m = s.nextInt(), k = s.nextInt();
        long[] heights = new long[n];

        for (int i = 0; i < n; i++) heights[i] = s.nextLong();

        for (int i = 0; i < n - 1; i++) {
            long diff = Math.abs(heights[i] - heights[i + 1]);
            if (diff <= k) {
                // if difference is less than k.
                if (heights[i] > heights[i + 1]) {
                    m += diff;
                }
            } else {
                long valueToAddOrRemove = diff - k;
                if (heights[i] < heights[i + 1]) {
                    if (m >= valueToAddOrRemove) {
                        m -= valueToAddOrRemove;
                    } else {
                        System.out.println("NO");
                        return;
                    }
                } else {
                    m += valueToAddOrRemove;
                }
            }
        }
        System.out.println("YES");
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
