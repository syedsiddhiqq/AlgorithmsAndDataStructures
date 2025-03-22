package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 28-04-2022, Thursday, 08:49
 */
public class AliceAndThCake {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        if (n == 1) {
            s.nextInt();
            System.out.println("YES");
        } else if (n == 2) {
            int a = s.nextInt(), b = s.nextInt();
            if (Math.abs(a - b) <= 2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else {
            Integer[] arr = new Integer[n];

            for(int i=0;i<n;i++) arr[i] = s.nextInt();

            Arrays.sort(arr);

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
