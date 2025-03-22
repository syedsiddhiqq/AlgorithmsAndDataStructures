package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 05-04-2022, Tuesday, 10:08
 */
public class Chocolate {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        int[] arr = new int[n];

        int ones = 0, zeroes = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
            if (arr[i] == 1) ones++;
            else zeroes++;
        }

        if (zeroes == n) {
            System.out.println(0);
        } else if (ones == 1 || ones == n) {
            System.out.println(1);
        } else {
            int start = 0;
            long ans = 1;
            while (start < n) {
                if (arr[start] == 1) {
                    int countZeroes = 0, j = start + 1;
                    for (j = start + 1; j < n; j++) {
                        if (arr[j] == 0) countZeroes++;
                        else break;
                    }
                    start = j;
                    if (start < n && arr[start] == 1) {
                        ans = countZeroes != 0 ? ans * (countZeroes + 1) : ans;
                    }
                } else {
                    start++;
                }
            }
            System.out.println(ans);
        }
    }

    public static void main(String[] args) {
        solve();
    }
}
