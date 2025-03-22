package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 27-03-2022, Sunday, 20:36
 */
public class AntiCoPrimePermutation {
    private static Scanner s = new Scanner(System.in);

    private static long mod = 998244353;

    private static long factorial(int n) {
        // single line to find factorial
        return (n == 1 || n == 0) ? 1 : (n * factorial(n - 1)) % mod;
    }

    private static void solve() {
        int n = s.nextInt();
        if (n % 2 == 1) {
            System.out.println(0);
        } else if (n == 2) {
            System.out.println(1);
        } else {
            System.out.println((factorial(n / 2) * factorial(n / 2)) % mod);
        }
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        //System.out.println(factorial(500));
        while (t-- > 0) {
            solve();
        }
    }
}
