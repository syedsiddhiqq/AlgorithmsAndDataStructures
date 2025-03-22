package CodeForces.RoadMap.Diff1400;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 30-04-2022, Saturday, 20:46
 */
public class Swaps {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
            map.put(a[i], i);
        }
        for (int i = 0; i < n; i++) {
            b[i] = s.nextInt();
            map.put(b[i], i);
        }

        int[] suff = new int[2 * n + 1];
        suff[2 * n] = map.get(2 * n);
        for (int j = 2 * n - 2; j >= 2; j -= 2) {
            suff[j] = Math.min(suff[j + 2], map.get(j));
        }


        int op = Integer.MAX_VALUE;
        for (int i = 1; i <= 2 * n - 1; i += 2) {
            int currOp = map.get(i) + suff[i + 1];
            op = Math.min(op, currOp);
        }
        System.out.println(op);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
