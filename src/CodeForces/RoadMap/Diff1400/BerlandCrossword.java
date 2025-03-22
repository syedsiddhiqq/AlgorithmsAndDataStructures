package CodeForces.RoadMap.Diff1400;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 13-05-2022, Friday, 10:30
 */
public class BerlandCrossword {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        Integer[] arr = new Integer[4];
        for (int i = 0; i < 4; i++) arr[i] = s.nextInt();

        Arrays.sort(arr, Collections.reverseOrder());

        if (arr[0] == n) {
            for (int i = 1; i < 4; i++) {
                if (arr[i] > n - 1) {
                    System.out.println("NO");
                    return;
                }
            }
        } else {
            for (int i = 0; i < 4; i++) {
                if (arr[i] > n - 1) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
