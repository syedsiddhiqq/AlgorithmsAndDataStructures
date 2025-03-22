package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 19-04-2022, Tuesday, 10:00
 */
public class VerseForSanta {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt(), secs = s.nextInt();

        long max = Long.MIN_VALUE, maxIndex = -1, sum = 0;
        long[] arr = new long[n];
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
            totalSum += arr[i];
        }

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (max < arr[i]) {
                max = arr[i];
                maxIndex = i;
            }
            if (sum > secs) {
                sum -= max;
                break;
            }
        }
        System.out.println(totalSum == sum ? 0 : maxIndex + 1);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
