package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 31-03-2022, Thursday, 10:23
 */
public class PrefixSumPrimes {
    private static Scanner s = new Scanner(System.in);

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void solve() {
        int n = s.nextInt();
        int[] arr = new int[n];
        int ones = 0, two = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
            if (arr[i] == 1) ones++;
            else two++;
        }

        int start = 0;
        if (ones == 0 || two == 0) {
            printArr(arr);
            return;
        } else {
            while (ones > 0 && two > 0) {
                if (start % 2 == 0) {
                    start += 1;
                    ones--;
                    System.out.print(1 + " ");
                }else{
                    start += 2;
                    two--;
                    System.out.print(2 + " ");
                }
            }

            while(ones > 0){
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        solve();
    }
}
