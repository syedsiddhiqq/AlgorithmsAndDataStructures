package CodeForces.contests.contest784div4;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 21-04-2022, Thursday, 20:13
 */
public class C {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        int[] arr = new int[n];

        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
            if (i % 2 == 0) {
                even.add(arr[i]);
            } else {
                odd.add(arr[i]);
            }
        }

        if (odd.get(0) % 2 == 1) {
            for (Integer o : odd) {
                if (o % 2 == 0) {
                    System.out.println("NO");
                    return;
                }
            }
        } else {
            for (Integer o : odd) {
                if (o % 2 == 1) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        if (even.get(0) % 2 == 1) {
            for (Integer e : even) {
                if (e % 2 == 0) {
                    System.out.println("NO");
                    return;
                }
            }
        } else {
            for (Integer e : even) {
                if (e % 2 == 1) {
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
