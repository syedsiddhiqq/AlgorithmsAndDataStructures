package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 14-04-2022, Thursday, 09:04
 */
public class TwoRoundDances {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        Scanner s = new Scanner(System.in);
        long n = s.nextInt(), x = 2;
        for (int i = 1; i < n; i++){
            x *= i;
        }
        System.out.println(x / n);
    }

    public static void main(String[] args) {
        solve();
        s.close();
    }
}
