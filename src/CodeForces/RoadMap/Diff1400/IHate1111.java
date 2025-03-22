package CodeForces.RoadMap.Diff1400;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 05-05-2022, Thursday, 08:37
 */
public class IHate1111 {
    private static Scanner s = new Scanner(System.in);

    private static long[] arr = {0, 0, 11, 111, 1111, 11111, 111111, 1111111, 11111111, 111111111, 1111111111, 11111111111L, 111111111111L, 111111111111111L};

    private static void solve() {
        long n = s.nextLong();

        while (n > 10) {
            int length = String.valueOf(n).length();
            long d = arr[length];
            d = d > n ? arr[length - 1] : d;
            n = n % d;
            if (n == 0) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
