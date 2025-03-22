package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;
import java.util.concurrent.Callable;
import java.util.stream.Stream;

/**
 * @author SyedAli
 * @createdAt 18-03-2022, Friday, 15:09
 */
public class CombinationLock {
    private static Scanner s = new Scanner(System.in);

    private static void solve(){
        int n = s.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) a[i] = s.nextInt();

        for (int mask = 0; mask < (1 << n); mask++) {
            int s = 0;
            for (int i = 0; i < n; i++) {
                int bit = (mask >> i) & 1;
                if (bit > 0) s += a[i];
                if (bit == 0) s -= a[i];
            }
            if (s % 360 == 0) {
                System.out.println("YES");
                return;
            }
        }
        System.out.print("NO");
    }

    public static void main(String[] args) {
        solve();
    }
}
