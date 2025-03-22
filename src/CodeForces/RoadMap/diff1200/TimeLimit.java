package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 29-03-2022, Tuesday, 08:26
 */
public class TimeLimit {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt(), m = s.nextInt();
        long correctMax = Long.MIN_VALUE, wrongMin = Long.MAX_VALUE, mulMin = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            long temp = s.nextLong();
            correctMax = Math.max(correctMax, temp);
            mulMin = Math.min(mulMin, temp * 2);
        }

        for (int j = 0; j < m; j++) {
            long temp = s.nextLong();
            wrongMin = Math.min(wrongMin, temp);
        }

        correctMax = Math.max(mulMin, correctMax);

        if (correctMax >= wrongMin) {
            System.out.println(-1);
        } else {
            System.out.println(correctMax);
        }
    }

    public static void main(String[] args) {
        solve();
    }
}
