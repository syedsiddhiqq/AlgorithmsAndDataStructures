package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 26-03-2022, Saturday, 14:13
 */
public class InterestingSubArray {

    private static Scanner s = new Scanner(System.in);

    private static void findInterestingArray() {
        int n = s.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = s.nextLong();
        for (int i = 1; i < n; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) > 1) {
                System.out.println("YES");
                System.out.println(i + " " + (i + 1));
                return;
            }
        }
        System.out.println("NO");
        // For tesing purpose.
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            findInterestingArray();
        }
    }
}
