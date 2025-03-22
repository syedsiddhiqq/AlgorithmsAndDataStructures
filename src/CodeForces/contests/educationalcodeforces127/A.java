package CodeForces.contests.educationalcodeforces127;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 22-04-2022, Friday, 19:54
 */
public class A {
    private static Scanner s = new Scanner(System.in);


    private static void solve() {
        char[] str = s.next().toCharArray();

        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'a') {
                if ((i - 1 >= 0 && str[i - 1] == 'a') || (i + 1 < str.length && str[i + 1] == 'a')) continue;
            } else {
                if ((i - 1 >= 0 && str[i - 1] == 'b') || (i + 1 < str.length && str[i + 1] == 'b')) continue;
            }
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
