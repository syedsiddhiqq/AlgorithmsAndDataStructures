package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 23-04-2022, Saturday, 21:59
 */
public class Swords {
    private static Scanner s = new Scanner(System.in);

    static long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    private static void solve() {
        int n = s.nextInt();
        long[] arr = new long[n];
        long max = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextLong();
            max = Math.max(max, arr[i]);
        }

        long gcd = -1;
        for (int i = 0; i < n; i++) {
            arr[i] = max - arr[i];
            if (arr[i] == 0) continue;
            if (gcd == -1) {
                gcd = arr[i];
            } else {
                gcd = gcd(gcd, arr[i]);
            }
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) continue;
            ans += (arr[i] / gcd);
        }

        System.out.println(ans + " " + gcd);
    }

    public static void main(String[] args) {
        solve();
        s.close();
    }
}
