package CodeForces.RoadMap.Diff1400;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 28-05-2022, Saturday, 12:03
 */
public class ElementExtermination {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        int max = arr[0];
        List<Integer> arrList = new ArrayList<>();
        arrList.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i - 1];
                arrList.clear();
                arrList.add(arr[i - 1]);
            } else {
                arrList.add(arr[i]);
            }
        }

        if (arrList.size() == 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
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
