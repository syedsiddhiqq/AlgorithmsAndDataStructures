package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 21-04-2022, Thursday, 09:58
 */
public class BalancedTunnel {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = s.nextInt() - 1;
        }


        for (int i = 0; i < n; i++) {
            end[i] = s.nextInt() - 1;
        }

        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[end[i]] = i;
        }

        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = pos[start[i]];
        }

        int max = -1, ans = 0;
        for (int i = 0; i < n; i++) {
            if (c[i] > max) {
                max = c[i];
            } else {
                ans++;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        solve();
        s.close();
    }
}
