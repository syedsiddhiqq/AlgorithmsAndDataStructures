package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 16-03-2022, Wednesday, 22:21
 */
public class SequenceWithDigits {

    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        Long a = s.nextLong();
        Long k = s.nextLong();

        for (Integer i = 2; i <= k; i++) {
            Integer min = Integer.MAX_VALUE;
            Integer max = Integer.MIN_VALUE;
            String strVal = String.valueOf(a);
            for (Integer j = 0; j <= 9; j++) {
                if (strVal.contains(String.valueOf(j))) {
                    min = Math.min(j, min);
                    max = Math.max(j, max);
                }
            }
            a += (min * max);
            if(min == 0 || max == 0) break;
        }
        System.out.println(a);
    }

    public static void main(String[] args) {
        Integer t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
