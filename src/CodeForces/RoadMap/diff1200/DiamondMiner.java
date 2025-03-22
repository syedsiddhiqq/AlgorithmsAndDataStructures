//package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 25-03-2022, Friday, 10:25
 */
public class DiamondMiner {
    private static Scanner s = new Scanner(System.in);

    private static void findEnergy() {
        int n = s.nextInt();
        Long[] miners = new Long[n];
        Long[] diamonds = new Long[n];

        int mine = 0, diamond = 0;
        for (int i = 0; i < 2 * n; i++) {
            Long x = s.nextLong(), y = s.nextLong();
            if (x == 0) {
                miners[mine++] = y < 0 ? (-1 * y) : y;
            } else {
                diamonds[diamond++] = x < 0 ? (-1 * x) : x;
            }
        }

        Arrays.sort(miners);
        Arrays.sort(diamonds);

        double ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.sqrt((miners[i] * miners[i]) + (diamonds[i] * diamonds[i]));
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            findEnergy();
        }
    }
}
