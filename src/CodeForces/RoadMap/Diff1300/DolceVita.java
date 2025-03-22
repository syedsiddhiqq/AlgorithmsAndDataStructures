package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 23-04-2022, Saturday, 10:53
 */
public class DolceVita {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt(), x = s.nextInt();
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) arr[i] = s.nextInt();
        Arrays.sort(arr);

        int ans = 0;
        while (arr[0] <= x) {
            int sum = 0, i = 0;
            for (i = 0; i < n; i++) {
                sum += arr[i];
                arr[i]++;
                if (sum > x) {
                    break;
                }
            }
            ans += i;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
