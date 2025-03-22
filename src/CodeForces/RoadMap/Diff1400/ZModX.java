package CodeForces.RoadMap.Diff1400;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 20-05-2022, Friday, 22:09
 */
public class ZModX {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        long a = s.nextLong(), b = s.nextLong(), c = s.nextLong();

        if (b + a > c) {
            System.out.println((b + a) + " " + b + " " + c);
        } else {
            System.out.println(((long) (b * c + a)) + " " + b + " " + c);
        }
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
