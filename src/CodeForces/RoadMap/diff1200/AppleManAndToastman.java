package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 28-03-2022, Monday, 09:10
 */
public class AppleManAndToastman {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        Integer[] arr = new Integer[n];
        long sum = 0, ans = 0, prev = sum;
        int start = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
            sum += arr[i];
        }

        ans += sum;
        prev = sum;
        Arrays.sort(arr);
        while (start < n - 1) {
            long prevCalc = (prev - arr[start]);
            long temp = (prevCalc + arr[start++]);
            ans += temp;
            prev = prevCalc;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        solve();
    }
}
