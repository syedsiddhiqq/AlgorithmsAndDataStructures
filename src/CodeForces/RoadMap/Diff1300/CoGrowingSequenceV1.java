package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 12-04-2022, Tuesday, 09:26
 */
public class CoGrowingSequenceV1 {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        long[] arr = new long[n];
        long[] result = new long[n];
        result[0] = 0;
        for (int i = 0; i < n; i++) arr[i] = s.nextLong();

        for (int i = 1; i < n; i++) {
            long temp = arr[i];
            while ((arr[i - 1] & (temp ^ result[i])) != arr[i - 1]) result[i] = ++temp;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
