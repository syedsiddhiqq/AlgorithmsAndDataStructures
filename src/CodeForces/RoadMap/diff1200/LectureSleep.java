package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 28-03-2022, Monday, 23:25
 */
public class LectureSleep {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt(), k = s.nextInt();
        int[] arr = new int[n];
        int[] sleep = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        int totalSum = 0;
        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            sleep[i] = s.nextInt();
            if (sleep[i] == 1) {
                totalSum += arr[i];
                if (i == 0) pre[i] = arr[i];
                else pre[i] = pre[i - 1];
            } else {
                if (i == 0) pre[i] = arr[i];
                else pre[i] = arr[i] + pre[i - 1];
            }
        }

        int segment = pre[k - 1];
        for (int i = k; i < n; i++) {
            segment = Math.max(segment, pre[i] - pre[i - k]);
        }
        System.out.println(totalSum + segment);
    }

    public static void main(String[] args) {
        solve();
    }
}
