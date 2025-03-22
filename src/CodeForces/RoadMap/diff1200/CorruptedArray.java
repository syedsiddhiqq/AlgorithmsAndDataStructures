package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 21-03-2022, Monday, 15:22
 */
public class CorruptedArray {
    private static Scanner s = new Scanner(System.in);

    private static void solveCorruptedArray() {
        int n = s.nextInt();
        long[] arr = new long[n + 2];

        long max = Long.MIN_VALUE, secondMax = Long.MIN_VALUE, sum = 0;
        int maxIndex = -1, secondMaxIndex = -1;

        Map<Long, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n + 2; i++) {
            arr[i] = s.nextInt();
            sum += arr[i];
            if (max < arr[i]) {
                secondMax = max;
                secondMaxIndex = maxIndex;
                max = arr[i];
                maxIndex = i;
            } else if (arr[i] > secondMax) {
                secondMax = arr[i];
                secondMaxIndex = i;
            }
            indexMap.put(arr[i], i);
        }

        long ans = sum - max - secondMax;
        if (ans == max || ans == secondMax) {
            for (int i = 0; i < n + 2; i++) {
                if (i == maxIndex || i == secondMaxIndex) continue;
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        } else {
            long diff = (sum - max) - max;
            if (indexMap.containsKey(diff) && indexMap.get(diff) != maxIndex) {
                for (int i = 0; i < n + 2; i++) {
                    if (i != indexMap.get(diff) && i != maxIndex) {
                        System.out.print(arr[i] + " ");
                    }
                }
                System.out.println();
                return;
            }
        }
        System.out.println(-1);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solveCorruptedArray();
            ;
        }
    }
}
