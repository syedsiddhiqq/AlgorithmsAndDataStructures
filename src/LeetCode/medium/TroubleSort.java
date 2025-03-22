package LeetCode.medium;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 16-04-2022, Saturday, 22:36
 */
public class TroubleSort {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        Integer[] arr = new Integer[n];
        Integer[] copy = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = copy[i] = s.nextInt();
        }

        int zero = 0, one = 0;
        for (int i = 0; i < n; i++) {
            int temp = s.nextInt();
            if (temp == 0) zero++;
            else one++;
        }

        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if(arr[i] != copy[i] && (zero == 0 || one == 0)){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
