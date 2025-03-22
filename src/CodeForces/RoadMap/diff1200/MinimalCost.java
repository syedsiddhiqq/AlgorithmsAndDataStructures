package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 31-03-2022, Thursday, 08:44
 */
public class MinimalCost {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        long n = s.nextLong(), u = s.nextLong(), v = s.nextLong();

        long prev = s.nextLong(), abs = -1;
        boolean ansFound = false;
        for (int i = 1; i < n; i++) {
            long temp = s.nextLong();
            abs = Math.max(abs, Math.abs(temp - prev));
            prev = temp;
        }
        if (abs == 0) {
            System.out.println(u + v);
        } else if (abs == 1) {
            System.out.println(Math.min(u, v));
        } else {
            System.out.println(0);
        }
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
