package CodeForces.RoadMap.Diff1300;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SyedAli
 * @createdAt 06-04-2022, Wednesday, 20:26
 */
public class ArrayAndOperations {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        int k = s.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        Arrays.sort(a);

        long res = 0;

        for (int i = 0; i < k; i++) {
            int f = (n - k + i);
            int l = (n - k + i - k);

            res += a[l] / a[f];
        }

        for (int i = 0; i < n - k - k; i++) {
            res += a[i];
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
