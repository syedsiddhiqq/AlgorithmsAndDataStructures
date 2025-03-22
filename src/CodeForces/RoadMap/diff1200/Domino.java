package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 25-03-2022, Friday, 21:11
 */
public class Domino {

    private static Scanner s = new Scanner(System.in);

    private static void calculateTime() {
        long totalSum = 0, xSum = 0, ySum = 0;
        int n = s.nextInt();
        long[] xArr = new long[n], yArr = new long[n];
        for (int i = 0; i < n; i++) {
            xArr[i] = s.nextLong();
            yArr[i] = s.nextLong();
            xSum += xArr[i];
            ySum += yArr[i];
            totalSum += (xArr[i] + yArr[i]);
        }

        if (totalSum % 2 == 0 && xSum % 2 == 0 && ySum % 2 == 0) {
            System.out.println(0);
        } else if (totalSum % 2 == 0 && xSum % 2 != 0 && ySum % 2 != 0) {
            for (int i = 0; i < n; i++) {
                if ((xArr[i] + yArr[i]) % 2 != 0) {
                    System.out.println(1);
                    return;
                }
            }
            System.out.println(-1);
        } else {
            System.out.println(-1);
        }
    }

    public static void main(String[] args) {
        calculateTime();
    }
}
