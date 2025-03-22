package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 01-04-2022, Friday, 10:46
 */
public class NastiaAndGoodArray {
    private static Scanner s = new Scanner(System.in);

    private static long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    private static int mod = (int) (1e6);

    private static boolean prime[] = new boolean[mod + 1];

    private static void sieveOfEratosthenes() {
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= mod; p++) {
            if (prime[p] == true) {
                for (int i = p * p; i <= mod; i += p)
                    prime[i] = false;
            }
        }
    }

    private static long findNextPrime(long start) {
        for (int i = (int) start + 1; i < mod; i++) {
            if (prime[i]) {
                return i;
            }
        }
        return 0;
    }

    private static void solve() {
        int n = s.nextInt();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) arr[i] = s.nextLong();


        long initialPrime = findNextPrime(3);
        List<String> result = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (gcd(arr[i], arr[i - 1]) != 1) {
                StringBuilder r = new StringBuilder();
                long minAb = Math.min(arr[i], arr[i - 1]);
                initialPrime = findNextPrime(Math.max(minAb, initialPrime));
                while (initialPrime < minAb) initialPrime = findNextPrime(Math.max(minAb, initialPrime));
                arr[i - 1] = initialPrime;
                arr[i] = minAb;
                // long gcd = gcd(arr[i - 1], arr[i]);
                if (initialPrime > minAb) {
                    r.append((i) + " " + (i + 1) + " ");
                    r.append(initialPrime + " " + minAb);
                }
                result.add(r.toString());
            }
        }
        System.out.println(result.size());
        for (String s1 : result) {
            System.out.println(s1);
        }
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        sieveOfEratosthenes();
        while (t-- > 0) {
            solve();
        }
    }
}
