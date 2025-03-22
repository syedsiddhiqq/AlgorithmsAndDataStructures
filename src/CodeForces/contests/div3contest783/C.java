package CodeForces.contests.div3contest783;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 02-05-2022, Monday, 20:00
 */
public class C {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        char[] input = s.next().toCharArray();
        String t = s.next();


        if (t.length() == 1 && t.charAt(0) == 'a') {
            System.out.println(1);
        } else if (t.contains("a")) {
            System.out.println(-1);
        } else {
            System.out.println((long) Math.pow(2, input.length));
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
