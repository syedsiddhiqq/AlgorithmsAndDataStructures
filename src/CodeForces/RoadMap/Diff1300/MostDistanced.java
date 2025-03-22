package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 01-04-2022, Friday, 09:49
 */
public class MostDistanced {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = s.nextInt();

        Boolean decreasing = null;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                if (decreasing == null || !decreasing) {
                    decreasing = true;
                    result.add(arr[i - 1]);
                }
            } else {
                if (decreasing == null || decreasing) {
                    decreasing = false;
                    result.add(arr[i - 1]);
                }
            }
        }

        System.out.println(result.size() + 1);
        for (Integer i : result) {
            System.out.print(i + " ");
        }
        System.out.println(arr[n - 1]);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
