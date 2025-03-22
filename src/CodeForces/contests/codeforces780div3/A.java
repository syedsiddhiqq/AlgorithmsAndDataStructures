package CodeForces.contests.codeforces780div3;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 31-03-2022, Thursday, 20:02
 */
public class A {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        long a = s.nextLong(), b = s.nextLong();

        if (a == 0) {
            System.out.println(1);
        } else {
            System.out.println(((2 * b) + a) + 1);
        }
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
