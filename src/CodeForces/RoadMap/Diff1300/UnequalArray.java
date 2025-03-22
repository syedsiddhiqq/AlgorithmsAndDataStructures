package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 24-04-2022, Sunday, 12:54
 */
public class UnequalArray {
    private static Scanner s = new Scanner(System.in);


    private static void solve() {
        int n = s.nextInt();
        int[] arr = new int[n];

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                min = Math.min(i - 1, min);
                max = Math.max(i, max);
            }
        }

        int ele = max - min + 1;
        if (ele >= 4) {
            System.out.println(ele - 3);
        } else if (ele == 3) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
