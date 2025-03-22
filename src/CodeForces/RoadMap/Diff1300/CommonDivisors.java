//package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 02-04-2022, Saturday, 18:28
 */
public class CommonDivisors {
    private static Scanner s = new Scanner(System.in);

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
        Collections.sort(divisors);
        return divisors;
    }

    private static long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    private static void solve() {
        Set<Long> set = new TreeSet<>();
        int n = s.nextInt();
        int odd = 0, even = 0;
        for (int i = 0; i < n; i++) {
            long temp = s.nextLong();
            set.add(temp);
            if (temp % 2 == 0) even++;
            else odd++;
        }

        if (even > 0 && odd > 0) {
            System.out.println(1);
            return;
        }

        List<Long> list = new ArrayList<>(set);
        List<Long> divisors = getDivisorsList(list.get(0));
        for (int j = 1; j < divisors.size(); j++) {
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) % divisors.get(j) != 0) {
                    System.out.println(j);
                    return;
                }
            }
        }
        System.out.println(divisors.size());
    }

    public static void main(String[] args) {
        solve();
    }
}
