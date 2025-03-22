package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 03-04-2022, Sunday, 19:16
 */
public class BigVova {
    private static Scanner s = new Scanner(System.in);

    private static class Pair {
        int val;
        int gcd;

        public Pair(int val, int gcd) {
            this.val = val;
            this.gcd = gcd;
        }
    }

    private static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    private static void solve() {
        int n = s.nextInt();
        int[] arr = new int[n];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
            max = Math.max(max, arr[i]);
        }


        List<Pair> elements = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            elements.add(new Pair(arr[i], gcd(max, arr[i])));
        }

        Collections.sort(elements, (a, b) -> {
            return b.gcd - a.gcd;
        });

        for (Pair element : elements) {
            System.out.print(element.val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
