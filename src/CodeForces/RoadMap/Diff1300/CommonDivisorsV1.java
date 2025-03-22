package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 02-04-2022, Saturday, 19:09
 */
public class CommonDivisorsV1 {
    private static Scanner s = new Scanner(System.in);

    private static long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    private static List<Long> getDivisorsList(long n) {
        List<Long> divisors = new ArrayList<>();
        // Note that this loop runs till square root
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                // If divisors are equal, print only one
                if (n / i == i)
                    divisors.add(Long.valueOf(i));
                else {// Otherwise print both
                    divisors.add(Long.valueOf(i));
                    divisors.add(n / i);
                }
            }
        }
        return divisors;
    }

    private static void solve() {
        int n = s.nextInt();
        long res = s.nextLong();
        for (int i = 1; i < n; i++) {
            res = gcd(res, s.nextLong());
        }

        int count = getDivisorsList(res).size();
        System.out.println(count);

    }

    public static void main(String[] args) {
        solve();
    }
}
