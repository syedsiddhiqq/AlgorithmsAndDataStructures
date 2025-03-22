package CodeForces.contests.div3contest783;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 02-05-2022, Monday, 20:00
 */
public class A {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int x = s.nextInt(), y = s.nextInt();
        if (y % x != 0) {
            System.out.println("0 0");
        } else {
            System.out.println(1 + " " + (y / x));
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
