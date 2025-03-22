package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 05-04-2022, Tuesday, 10:36
 */
public class RoadConstruction {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt(), m = s.nextInt();
        int[] freq = new int[n + 1];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int a = s.nextInt(), b = s.nextInt();
            freq[a] = 1;
            freq[b] = 1;
            set.add(a);
            set.add(b);
        }

        for (int i = 1; i <= n; i++) {
            if (freq[i] == 0 && !set.contains(i)) {
                System.out.println(n - 1);
                for (int j = 1; j <= n; j++) {
                    if (i == j) continue;
                    System.out.println(i + " " + j);
                }
                return;
            }
        }
    }

    public static void main(String[] args) {
        solve();
    }
}
