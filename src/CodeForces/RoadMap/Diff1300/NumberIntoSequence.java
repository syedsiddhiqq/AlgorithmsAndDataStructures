package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 02-04-2022, Saturday, 09:08
 */
public class NumberIntoSequence {
    private static Scanner s = new Scanner(System.in);

    private static void findDivisors(List<Long> result, long n, long d) {
        while (n > 0) {
            long divident = n / d;
            if (divident % d != 0) {
                result.add(n);
                return;
            }
            result.add(d);
            n = divident;
        }
    }

    private static boolean isPrime(long number) {
        if (number < 2) return false;
        if (number % 2 == 0) return (number == 2);
        int root = (int) Math.sqrt((double) number);
        for (int i = 3; i <= root; i += 2) {
            if (number % i == 0) return false;
        }
        return true;
    }

    private static void solve() {
        long n = s.nextLong();
        List<Long> result = new ArrayList<>();
        List<Long> finalList = new ArrayList<>();
        long ans = 1;
        if (isPrime(n)) {
            System.out.println(ans);
            System.out.println(n);
            return;
        } else {
            int upto = (int) Math.sqrt((double) n);
            for (int i = 2; i <= upto; i++) {
                if (n % i == 0) {
                    result.clear();
                    findDivisors(result, n, i);
                    if (ans < result.size()) {
                        ans = result.size();
                        finalList = new ArrayList<>(result);
                    }
                }
            }
        }
        if (finalList.isEmpty()) {
            System.out.println(1);
            System.out.println(n);
        } else {
            System.out.println(finalList.size());
            for (Long a : finalList) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        sieveOfEratosthenes();
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
