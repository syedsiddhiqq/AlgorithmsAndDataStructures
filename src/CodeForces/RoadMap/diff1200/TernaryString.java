package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 15-03-2022, Tuesday, 23:45
 */
public class TernaryString {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        char[] str = s.next().toCharArray();
        int one, two, three;
        one = two = three = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < str.length; i++) {
            if (str[i] == '1') {
                one = i;
            } else if (str[i] == '2') {
                two = i;
            } else {
                three = i;
            }

            if (one != Integer.MAX_VALUE && two != Integer.MAX_VALUE && three != Integer.MAX_VALUE) {
                ans = Math.min(ans, i - Math.min(one, Math.min(two, three)) + 1);
            }
        }
        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
