package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 03-04-2022, Sunday, 08:51
 */
public class CaninePoetry {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        char[] str = s.next().toCharArray();
        int n = str.length;
        if (n == 1) {
            System.out.println(0);
        } else if (n == 2) {
            if (str[0] == str[1]) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        } else {
            for (int i = 1; i < n; i++) {
                if (str[i] == str[i - 1] || (i - 2 >= 0 && str[i] == str[i - 2])) {
                    str[i] = '*';
                }
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                if (str[i] == '*') count++;
            }
            System.out.println(count);
        }
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
