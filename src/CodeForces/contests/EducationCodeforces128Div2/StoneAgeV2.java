package CodeForces.contests.EducationCodeforces128Div2;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 14-05-2022, Saturday, 16:24
 */
public class StoneAgeV2 {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt(), q = s.nextInt();
        long[] arr = new long[n];

        long sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextLong();
            sum += arr[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int type = s.nextInt();
            if (type == 1) {
                int index = s.nextInt() - 1;
                long x = s.nextLong();
                sum -= arr[index];
                sum += x;
                arr[index] = x;
            } else if (type == 2) {
                long x = s.nextLong();
                sum = x * n;
                Arrays.fill(arr, x);
            }
            sb.append(sum + "\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) {
        solve();
        s.close();
    }

}
