package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 24-04-2022, Sunday, 10:07
 */
public class LogChopping {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = s.nextInt();

        char curr = 'a';
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 1) continue;
            if (curr == 'a') {
                if (arr[i] % 2 == 0) {
                    curr = 'b';
                }
            } else {
                if (arr[i] % 2 == 0) {
                    curr = 'a';
                }
            }
        }

        System.out.println(curr == 'a' ? "maomao90" : "errorgorn");
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
