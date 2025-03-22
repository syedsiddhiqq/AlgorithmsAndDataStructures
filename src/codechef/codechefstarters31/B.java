package codechef.codechefstarters31;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 23-03-2022, Wednesday, 19:56
 */
public class B {

    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        char[] str = s.next().toCharArray();

        int ones = 0, zero = 0;
        for (int i = 0; i < n; i++) {
            if (str[i] == '0') zero++;
            else ones++;
        }

        if (ones == 0 && zero == 0) {
            System.out.println(0);
        } else if (ones == 0 || zero == 0) {
            System.out.println(1);
        } else {
            long ans = (Math.min(ones, zero) * 2) + 1;
            System.out.println(ans > n ? ans - 1 : ans);
        }
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
