package CodeForces.contests.EducationalContest129;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 23-05-2022, Monday, 20:10
 */
public class A {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        int aMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            aMax = Math.max(aMax, s.nextInt());
        }

        int m = s.nextInt();
        int bMax = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            bMax = Math.max(bMax, s.nextInt());
        }

        if (aMax > bMax) {
            System.out.println("Alice");
            System.out.println("Alice");
        } else if (bMax > aMax) {
            System.out.println("Bob");
            System.out.println("Bob");
        } else {
            System.out.println("Alice");
            System.out.println("Bob");
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
