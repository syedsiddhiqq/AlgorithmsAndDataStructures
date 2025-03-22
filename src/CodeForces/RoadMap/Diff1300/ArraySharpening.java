package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 19-04-2022, Tuesday, 09:15
 */
public class ArraySharpening {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = s.nextInt();

        int prefixEnd = -1, suffixEnd = n;
        for (int i = 0; i < n; i++) {
            if (arr[i] < i) break;
            prefixEnd = i;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] < (n - 1) - i) break;
            suffixEnd = i;
        }

        if (suffixEnd <= prefixEnd) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
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
