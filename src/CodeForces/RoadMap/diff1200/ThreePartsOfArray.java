package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 23-03-2022, Wednesday, 08:49
 */
public class ThreePartsOfArray {
    private static Scanner s = new Scanner(System.in);

    private static void splitThreeParts() {
        int n = s.nextInt();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++)
            arr[i] = s.nextLong();

        long aSum = 0, cSum = 0,finalAns = 0;
        int i = 0, j = n - 1;
        while (i <= j) {
            if(aSum <= cSum){
                aSum += arr[i];
                i++;
            }else{
                cSum += arr[j];
                j--;
            }

            if(aSum == cSum) finalAns = aSum;
        }
        System.out.println(finalAns);
    }

    public static void main(String[] args) {
        splitThreeParts();
    }
}
