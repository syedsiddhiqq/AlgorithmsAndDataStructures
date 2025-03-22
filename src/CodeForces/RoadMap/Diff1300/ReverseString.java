package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 12-04-2022, Tuesday, 08:38
 */
public class ReverseString {
    private static Scanner s = new Scanner(System.in);

    private static boolean check(char[] str, char[] t, int aStart, int bStart, boolean right, boolean left) {

        if ((left && bStart >= t.length - 1) || (right && bStart >= t.length - 1)) return true;

        // if (aStart - 1 < 0 || aStart + 1 >= str.length || bStart + 1 >= t.length) return true;

        boolean rightCheck = false, leftCheck = false;

        if (right && aStart + 1 < str.length && bStart + 1 < t.length && str[aStart + 1] == t[bStart + 1]) {
            rightCheck = check(str, t, aStart + 1, bStart + 1, true, true);
        }

        if (left && aStart - 1 >= 0 && bStart + 1 < t.length && str[aStart - 1] == t[bStart + 1]) {
            leftCheck = check(str, t, aStart - 1, bStart + 1, false, true);
        }

        return rightCheck || leftCheck;
    }

    private static void solve() {
        char[] str = s.next().toCharArray();
        char[] t = s.next().toCharArray();
        int aStart = 0, bStart = 0;
        while (aStart < str.length) {
            if (str[aStart] == t[0]) {
                if (check(str, t, aStart, 0, true, true)) {
                    System.out.println("YES");
                    return;
                }
            }
            aStart++;
        }
        System.out.println("NO");
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
