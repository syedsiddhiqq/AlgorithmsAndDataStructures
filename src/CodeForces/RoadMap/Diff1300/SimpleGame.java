package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 04-04-2022, Monday, 22:15
 */
public class SimpleGame {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        long n = s.nextLong(), m = s.nextLong();
        if (n == 1) {
            System.out.println(n);
        } else if (m == 1) {
            System.out.println(m + 1);
        } else if (m == n) {
            System.out.println(m - 1);
        } else {
            long nByTwo = n / 2 + n % 2;
            System.out.println(nByTwo == m ? nByTwo + 1 : nByTwo);
        }
    }

    public static void main(String[] args) {
        solve();
    }
}
