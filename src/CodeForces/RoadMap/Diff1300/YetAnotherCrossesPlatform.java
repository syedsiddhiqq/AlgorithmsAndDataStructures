package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 25-04-2022, Monday, 08:44
 */
public class YetAnotherCrossesPlatform {
    private static Scanner sc = new Scanner(System.in);

    private static void solve() {
        int n, m;
        int[] rows, cols;
        String[] arr;
        String s;
        n = sc.nextInt();
        m = sc.nextInt();
        rows = new int[n];
        cols = new int[m];
        arr = new String[n];
        for (int i = 0; i < n; i++) {
            s = sc.next();
            arr[i] = s;
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == '*') {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int res;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res = n - rows[i] + m - cols[j];
                if (arr[i].charAt(j) == '.') res--;
                if (res < min) min = res;
            }
        }

        System.out.println(min);
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
        sc.close();
    }
}
