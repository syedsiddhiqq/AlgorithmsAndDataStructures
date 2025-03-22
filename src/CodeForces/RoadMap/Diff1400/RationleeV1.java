package CodeForces.RoadMap.Diff1400;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 30-05-2022, Monday, 10:58
 */
public class RationleeV1 {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        int t = kb.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int cc = 0; cc < t; cc++) {

            int n = kb.nextInt();
            int k = kb.nextInt();
            int one = 0;

            int[] a = new int[n];
            int[] w = new int[k];

            for (int i = 0; i < n; i++) {
                a[i] = kb.nextInt();
            }
            for (int i = 0; i < k; i++) {
                w[i] = kb.nextInt();
                if (w[i] == 1) {
                    one++;
                }
            }
            int temp = 0;
            long happy = 0;
            int down = 0;
            int up = n - 1;

            Arrays.sort(a);
            Arrays.sort(w);

            for (int i = 0; i < one; i++) {
                happy = happy + 2 * a[up];
                up--;
            }

            for (int i = 0; i < k; i++) {
                if (w[k - 1 - i] != 1) {
                    happy = happy + a[down] + a[up];
                    down = down + w[k - 1 - i] - 1;
                    up--;

                }
            }


            sb.append(happy+"\n");
        }

        System.out.println(sb);
    }
}
