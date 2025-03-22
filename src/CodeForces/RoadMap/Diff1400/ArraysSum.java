package CodeForces.RoadMap.Diff1400;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 21-05-2022, Saturday, 10:27
 */
public class ArraysSum {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt(), k = s.nextInt(), sum = 0;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
            sum += arr[i];
        }

        int newSum = 0;
        int[] m;
        while (true) {
            m = new int[n];
            for (int i = 0; i < n; i++) {
                if (arr[i] == 0) continue;

            }
        }
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
