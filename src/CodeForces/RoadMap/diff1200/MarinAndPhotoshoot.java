package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 27-03-2022, Sunday, 20:29
 */
public class MarinAndPhotoshoot {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        char[] str = s.next().toCharArray();

        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (str[i] == '0' && str[i - 1] == '0') {
                ans += 2;
            } else if (str[i] == '1' && str[i - 1] == '0' && (i + 1) < n && str[i + 1] == '0') {
                ++ans;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
