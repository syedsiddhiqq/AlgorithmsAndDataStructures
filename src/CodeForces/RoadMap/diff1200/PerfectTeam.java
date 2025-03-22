package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 21-03-2022, Monday, 21:49
 */
public class PerfectTeam {
    private static Scanner s = new Scanner(System.in);

    private static void findPerfectTeam() {
        long c = s.nextLong(), m = s.nextLong(), x = s.nextLong();
        System.out.println(Math.min(Math.min(c,m), (c + m + x)/3));
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            findPerfectTeam();
        }
    }
}
