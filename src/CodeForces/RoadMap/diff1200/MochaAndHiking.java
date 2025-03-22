package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 23-03-2022, Wednesday, 09:28
 */
public class MochaAndHiking {
    private static Scanner s = new Scanner(System.in);

    private static void findPaths() {
        int n = s.nextInt();
        int[] arr = new int[n];

        boolean allZeroes = true, allOnes = true, zeroAndOne = false;
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();

            if (arr[i] != 0) allZeroes = false;
            if (arr[i] != 1) allOnes = false;
            if (i > 0 && ((arr[i] == 0 && arr[i - 1] == 1))) zeroAndOne = true;
        }

        if (allZeroes || arr[n - 1] == 0) {
            for (int i = 1; i <= n; i++) {
                System.out.print(i + " ");
            }
            System.out.println(n + 1);
        } else if (allOnes || arr[0] == 1) {
            System.out.print(n + 1 + " ");
            for (int i = 1; i <= n; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else if (zeroAndOne) {
            boolean once = true;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] == 0 && arr[i + 1] == 0 && once) {
                    System.out.print(i + " " + (n + 1));
                    once = false;
                } else {
                    System.out.println(i + " ");
                }
            }
        } else {
            System.out.println(-1);
        }
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            findPaths();
        }
    }
}
