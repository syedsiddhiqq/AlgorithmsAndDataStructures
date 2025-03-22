package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 15-03-2022, Tuesday, 11:55
 */
public class DiameterOfGraph {
    private static boolean solve(int n, int m, int k) {
        if (k <= -1) return false;
        if (m > (long) (n) * (n - 1) / 2 || m < n - 1) return false;
        if (k == 0) return n == 1;
        if (k == 1) return m == (long) (n) * (n - 1) / 2;

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            if (solve(n, m, k - 2)) {
                sb.append("YES");
            } else sb.append("NO");
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
