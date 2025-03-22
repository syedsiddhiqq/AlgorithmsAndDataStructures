package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 16-04-2022, Saturday, 09:32
 */
public class CookieForYOu {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        long a = s.nextLong(), b = s.nextLong(), n = s.nextLong(), m = s.nextLong();
        System.out.println(a + b >= n + m && m <= Math.min(a, b) ? "Yes" : "No");
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
