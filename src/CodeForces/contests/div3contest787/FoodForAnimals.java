package CodeForces.contests.div3contest787;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 05-05-2022, Thursday, 20:06
 */
public class FoodForAnimals {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        long a = s.nextLong(), b = s.nextLong(), c = s.nextLong(), x = s.nextLong(), y = s.nextLong();

        x -= a;
        y -= b;

        if (x > 0) {
            if (x > c) {
                System.out.println("NO");
                return;
            } else {
                c -= x;
                if (y > 0) {
                    if (y > c) {
                        System.out.println("NO");
                        return;
                    }
                }
            }
        } else if (y > 0) {
            if (y > c) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
