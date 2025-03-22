package CodeForces.contests.div3contest787;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 05-05-2022, Thursday, 20:17
 */
public class MakeItIncreasing {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        Long[] arr = new Long[n];
//        Long[] copy = new Long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextLong();
//            copy[i] = arr[i];
        }


        long op = 0;
        for (int i = n - 2; i >= 0; i--) {
            long curr = arr[i];
            long next = arr[i + 1];

            if(next == 0){
                System.out.println(-1);
                return;
            }

            while (curr >= next) {
                op++;
                curr = curr / 2;
            }
            arr[i] = curr;
        }

        System.out.println(op);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
