package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 26-04-2022, Tuesday, 10:06
 */
public class EhabAndColoringProblem {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        int[] arr = new int[n + 1];
        boolean[] filled = new boolean[n + 1];
        Arrays.fill(filled, true);
        if (n == 2) {
            System.out.println(1);
        } else if (n == 3) {
            System.out.println(2 + " " + 1);
        } else if (n >= 4) {
            int start = 1;
            arr[1] = 2;
            arr[2] = 1;
            for (int i = 2; i <= n; i++) {
                if (filled[i]) {
                    for (int j = i; j <= n; j += i) {
                        if (filled[j]) {
                            arr[j] = start;
                            filled[j] = false;
                        }
                    }
                    start++;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <= n; i++) {
                sb.append(arr[i] + " ");
            }
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        solve();
        s.close();
    }
}
