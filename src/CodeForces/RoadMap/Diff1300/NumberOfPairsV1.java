package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 12-04-2022, Tuesday, 10:26
 */
public class NumberOfPairsV1 {
    private static Scanner s = new Scanner(System.in);

    private static long l;

    private static long r;

    private static long merge(long[] arr, int start, int mid, int end) {
        long[] left = Arrays.copyOfRange(arr, start, mid + 1);
        long[] right = Arrays.copyOfRange(arr, mid + 1, end + 1);

        int a = 0, b = 0, k = start, count = 0;
        while (a < left.length && b < right.length) {
            long sum = left[a] + right[b];
            if (sum >= l && sum <= r) count++;
            if (left[a] <= right[b]) {
                arr[k++] = left[a++];
            } else {
                arr[k++] = right[b++];
            }
        }

        while (a < left.length) {
            arr[k++] = left[a++];
        }

        while (b < right.length) {
            arr[k++] = right[b++];
        }
        return count;
    }

    private static long mergeSort(long[] arr, int start, int end) {
        int mid = (start + end) / 2;
        long count = 0;
        if (start < end) {
            count += mergeSort(arr, start, mid);
            count += mergeSort(arr, mid + 1, end);
            count += merge(arr, start, mid, end);
        }
        return count;
    }

    private static void solve() {
        int n = s.nextInt();
        l = s.nextLong();
        r = s.nextLong();

        long[] arr = new long[n];

        for (int i = 0; i < n; i++) arr[i] = s.nextLong();

        System.out.println(mergeSort(arr, 0, n - 1));
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
