package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 20-04-2022, Wednesday, 21:52
 */
public class BeautifulNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {

            int n = in.nextInt(), i, a[] = new int[n], max = 0, min = n;
            for (i = 0; i < n; i++)
                a[in.nextInt() - 1] = i;

            for (i = 0; i < n; i++) {
                max = Math.max(max, a[i]);
                min = Math.min(min, a[i]);
                System.out.print(max - min == i ? 1 : 0);
            }
            System.out.println();
        }
        in.close();
    }
}
