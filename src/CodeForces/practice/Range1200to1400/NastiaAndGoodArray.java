package CodeForces.practice.Range1200to1400;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 11-02-2023, Saturday, 15:14
 */
public class NastiaAndGoodArray {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = s.nextInt();

        System.out.println(n - 1);
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                arr[i] = Integer.MAX_VALUE;
                System.out.print(i + " " + (i+1) + " " + arr[i - 1] + " " + arr[i]);
            } else {
                arr[i - 1] = Integer.MAX_VALUE;
                System.out.print(i + " " + (i+1) + " " + arr[i - 1] + " " + arr[i]);
            }
            System.out.println();
        }


        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
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
