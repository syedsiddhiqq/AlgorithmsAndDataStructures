package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 14-04-2022, Thursday, 09:59
 */
public class HugeBoxesOfToys {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        long a = s.nextLong(), b = s.nextLong(), c = s.nextLong(), d = s.nextLong();
        if (a == 0 && d == 0) {
            if (b % 2 == 0)
                System.out.println("Tidak Tidak Ya Tidak");
            else
                System.out.println("Tidak Ya Tidak Tidak");
        } else if (b == 0 && c == 0) {
            if (a % 2 == 0)
                System.out.println("Tidak Tidak Tidak Ya");
            else
                System.out.println("Ya Tidak Tidak Tidak");
        } else {
            if ((a + b) % 2 == 0)
                System.out.println("Tidak Tidak Ya Ya");
            else
                System.out.println("Ya Ya Tidak Tidak");
        }
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
