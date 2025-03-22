package CodeForces.RoadMap.Diff1300;

import java.util.*;

/**
 * @author SyedAli
 * @createdAt 06-04-2022, Wednesday, 19:43
 */
public class CreatingACharacter {
    private static Scanner in = new Scanner(System.in);

    private static void solve() {
        long a = in.nextLong();
        long b = in.nextLong();
        long c = in.nextLong();
        if (a + c <= b) {
            System.out.println(0);
            return;
        }
        if (c == 0 && a > b) {
            System.out.println(1);
            return;
        }
        long d = (b + c - a);
        d = d >= 0 ? d / 2 : -1;
        c -= d;
        System.out.println(c);
    }

    public static void main(String[] args) {
        int t = in.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
