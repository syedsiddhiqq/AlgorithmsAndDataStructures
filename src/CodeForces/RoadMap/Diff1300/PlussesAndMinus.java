package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 01-04-2022, Friday, 21:17
 */
public class PlussesAndMinus {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        String str = s.next();
        long cur = 0, ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+')
                cur++;
            else
                cur--;
            if (cur < 0) {
                ans += (i + 1);
                cur = 0;
            }
        }
        ans += str.length();
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
