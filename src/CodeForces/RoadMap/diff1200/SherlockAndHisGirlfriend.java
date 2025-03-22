package CodeForces.RoadMap.diff1200;

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 27-03-2022, Sunday, 15:14
 */
public class SherlockAndHisGirlfriend {
    private static Scanner s = new Scanner(System.in);

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

    private static void solve() {
        int n = s.nextInt();
        if (n > 2) {
            System.out.println(2);
        } else {
            System.out.println(1);
        }

        for (int i = 2; i <= n + 1; i++) {
            if (!prime[i]) {
                System.out.print(2 + " ");
            } else {
                System.out.print(1 + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        sieveOfEratosthenes();
        solve();
    }
}
