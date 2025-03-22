package CodeForces.contests.codeforces781div2;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 08-04-2022, Friday, 20:03
 */
public class A {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        long n = s.nextLong();

        long c = 1, d = 1, b = 1;
        long a = n - 3;
        System.out.println(a + " " + b + " " + c + " " + d);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
