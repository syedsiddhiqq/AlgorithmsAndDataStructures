package CodeForces.contests.educationalcodeforces127;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 22-04-2022, Friday, 20:39
 */
public class B {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = s.nextInt();

        int diff2 = 0, diff3 = 0;
        for (int i = 1; i < n; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff == 2) diff2++;
            else if (diff == 3) diff3++;
            else if (diff > 3) {
                System.out.println("NO");
                return;
            }
        }

        if ((diff2 <= 2 && diff3 == 0) || (diff3 == 1 && diff2 == 0) || (diff2 == 0 && diff3 == 0)) {
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
