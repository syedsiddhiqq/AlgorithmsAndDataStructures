package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 25-03-2022, Friday, 20:48
 */
public class Stairs {

    private static Scanner s = new Scanner(System.in);

    private static void findNiceStairs() {
        long x = s.nextLong();
        long niceStairs = 1;
        long currentNumberOfCells = 1;
        long ans = 0;
        while (x >= currentNumberOfCells) {
            x -= currentNumberOfCells;
            ans++;
            niceStairs = niceStairs * 2 + 1;
            currentNumberOfCells = (niceStairs * (niceStairs + 1) / 2);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            findNiceStairs();
        }
    }
}
