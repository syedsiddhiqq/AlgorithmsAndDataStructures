package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 24-04-2022, Sunday, 10:35
 */
public class IloveAAB {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        String inputStr = s.next();
        char[] str = inputStr.toCharArray();
        int start = 0, n = str.length;
        while (start < n) {
            boolean invalid = false;
            if (str[0] == 'B' || str[1] == 'A') invalid = true;
            int a = 0, b = 0;
            if (str[start] == 'A') {
                a++;
                while (++start < n && str[start] == 'A') {
                    a++;
                }

                while (start < n && str[start] == 'B') {
                    start++;
                    b++;
                }
                if (b > a || b == 0) {
                    invalid = true;
                }
            } else {
                invalid = true;
            }

            if (invalid) {
                System.out.println("NO");
                return;
            }
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