package codechef.codechefstarters31;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 23-03-2022, Wednesday, 19:56
 */
public class C {

    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        long n = s.nextLong();

        long ans = (n / 2) + (n % 2);
        if (n % 2 == 0) {
            System.out.println(ans);
        } else {
            System.out.println(-1 * ans);
        }
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

}
