package CodeForces.contests.contest784div4;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 21-04-2022, Thursday, 21:04
 */
public class D {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        String inputStr = s.next();
        char[] str = inputStr.toCharArray();
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            while (i < n && str[i] == 'W') i++;
            if (i == n) break;
            int blue = 0, red = 0;
            while (i < n && str[i] != 'W') {
                if (str[i] == 'R') red++;
                else blue++;
                i++;
            }
            if (red == 0 || blue == 0) {
                flag = false;
                break;
            }
        }
        if (flag) System.out.println("YES");
        else System.out.println("NO");
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
