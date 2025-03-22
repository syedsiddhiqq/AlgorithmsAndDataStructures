package CodeForces.contests.div3contest783;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 02-05-2022, Monday, 21:49
 */
public class E {
    private static Scanner s = new Scanner(System.in);

    private static Integer d(Integer n) {
        if (n % 2 == 1) return ((n / 2) + 1);
        return n / 2;
    }

    private static void solve() {
        int n = s.nextInt();
        int[] arr = new int[n];
        Integer[] copy = new Integer[n];

        for (int i = 0; i < n; i++) {
            int temp = s.nextInt();
            arr[i] = temp;
            copy[i] = temp;
        }

        Arrays.sort(copy);
        int ans = d(copy[0]) + d(copy[1]);


        for (int i = 1; i < n; i++) {

            if (i - 1 >= 0 && i + 1 < n) {
                if (arr[i - 1] == 1 && arr[i + 1] == 1) {
                    ans = 1;
                }
            }

            int a = arr[i - 1];
            int b = arr[i];

            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            int x = d(b);
            int op = x;
            int ca = a;
            a -= x;
            if (a > 0) {
                op += d(a);
            }

            int op2 = x - 1;
            ca -= (x - 1);
            if (ca > 0) {
                op2 += d(ca);
            } else {
                op2 = x;
            }
            ans = Math.min(Math.min(op, op2), ans);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        solve();
        s.close();
    }
}
