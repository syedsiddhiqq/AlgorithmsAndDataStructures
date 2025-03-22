package CodeForces.contests.codeforces780div3;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 31-03-2022, Thursday, 20:24
 */
public class VladAndCandies {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int max = 0;
        int max2 = 0;
        int t = in.nextInt();
        while (--t >= 0) {
            max = 0;
            max2 = 0;
            int n = in.nextInt();
            for (int i = 0; i < n; ++i) {
                int temp = in.nextInt();
                if (temp >= max) {
                    max2 = max;
                    max = temp;
                } else if (temp > max2) {
                    max2 = temp;
                }
            }
            if (max - max2 >= 2) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
