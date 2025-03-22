package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 27-03-2022, Sunday, 14:17
 */
public class VanyaAndBooks {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        long size = 0;
        long n = s.nextLong();
        char[] str = String.valueOf(n).toCharArray();

        long prev = 0, next = 9, multi = 1, ans = 0;
        for (int j = str.length - 1; j >= 0; j--) {
            if (j != 0) {
                ans += (next - prev) * multi++;
                prev = next;
                next = prev * 10 + 9;
            }else{
                ans += (n - prev) * multi;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        solve();
    }
}
