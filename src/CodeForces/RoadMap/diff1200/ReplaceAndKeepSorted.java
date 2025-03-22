package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 26-03-2022, Saturday, 19:59
 */
public class ReplaceAndKeepSorted {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int n = s.nextInt(), q = s.nextInt();
        long k = s.nextLong();
        long[] arr = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = s.nextLong();
        }

        while (q-- > 0) {
            int l = s.nextInt(), r = s.nextInt();
            long ans = 0;
            long temp = (arr[l + 1] - 2);
            ans += temp > 0 ? temp : 0;
            temp = (k - arr[r - 1] - 1);
            ans += temp > 0 ? temp : 0;
            for (int i = l + 1; i <= r - 1; i++) {
                temp = arr[i + 1] - arr[i - 1] - 2;
                ans += temp > 0 ? temp : 0;
            }
            System.out.println(ans);
        }
    }
}
