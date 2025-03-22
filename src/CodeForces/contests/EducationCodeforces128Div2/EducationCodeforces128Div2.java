package CodeForces.contests.EducationCodeforces128Div2;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 14-05-2022, Saturday, 10:36
 */
public class EducationCodeforces128Div2 {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int l1 = s.nextInt(), r1 = s.nextInt(), l2 = s.nextInt(), r2 = s.nextInt();
        if (l2 <= r1 && l1 <= r2) {
            System.out.println(Math.max(l1, l2));
        } else {
            System.out.println(l1 + l2);
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
