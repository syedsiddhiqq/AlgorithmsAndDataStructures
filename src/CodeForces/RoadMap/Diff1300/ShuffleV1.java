package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 16-04-2022, Saturday, 11:54
 */
public class ShuffleV1 {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt(), x = s.nextInt(), m = s.nextInt();
        int start = x, end = x;
        for (int i = 0; i < m; i++) {
            int a = s.nextInt(), b = s.nextInt();
            if (start >= a && start <= b || end >= a && end <= b) {
                start = Math.min(start, a);
                end = Math.max(end, b);
            }
        }
        System.out.println(end - start + 1);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
