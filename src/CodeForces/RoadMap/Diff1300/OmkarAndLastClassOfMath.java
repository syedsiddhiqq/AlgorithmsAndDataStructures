package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 15-04-2022, Friday, 10:52
 */
public class OmkarAndLastClassOfMath {
    private static Scanner s = new Scanner(System.in);

    private static long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    private static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    private static void solve() {
        long n = s.nextLong();

        if (n % 2 == 0) {
            System.out.println(n / 2 + " " + n / 2);
        } else {
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    System.out.println(n / i + " " + (n - n / i));
                    return;
                }
            }
            System.out.println(1 + " " + (n - 1));
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
