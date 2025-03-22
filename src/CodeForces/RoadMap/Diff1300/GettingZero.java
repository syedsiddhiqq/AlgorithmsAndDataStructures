package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 11-04-2022, Monday, 21:37
 */
public class GettingZero {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        while (n-- > 0) {
            int ans = 15;
            int a = s.nextInt();
            int count = 0, operations = 0;
            while (a > 5) {
                if (a % 2 == 0) {
                    count++;
                    a = a / 2;
                } else {
                    a++;
                    operations++;
                }
            }

            System.out.println(Math.min(ans, 15 - count + operations));
        }
    }

    public static void main(String[] args) {
        solve();
        s.close();
    }
}
