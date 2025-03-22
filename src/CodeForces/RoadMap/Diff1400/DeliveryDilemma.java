package CodeForces.RoadMap.Diff1400;

import com.sun.security.jgss.GSSUtil;

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 18-05-2022, Wednesday, 10:43
 */
public class DeliveryDilemma {
    private static Scanner s = new Scanner(System.in);

    private static class Pair {
        Integer a;
        Integer b;
    }
    public static void main(String[] args) {
        int t = s.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = s.nextInt();
            Pair[] pairs = new Pair[n];

            long sumA = 0, sumB = 0, ans = Long.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                pairs[i] = new Pair();
                pairs[i].a = s.nextInt();
                sumA = Math.max(sumA, pairs[i].a);
            }

            for (int i = 0; i < n; i++) {
                pairs[i].b = s.nextInt();
                sumB += pairs[i].b;
            }

            ans = Math.min(sumA, sumB);

            Arrays.sort(pairs, Comparator.comparingInt(a -> a.a));

            long hybrid = 0;
            for (int i = n - 1; i >= 1; i--) {
                hybrid += pairs[i].b;
                if (hybrid > ans) {
                    break;
                }
                ans = Math.min(Math.max(hybrid, pairs[i - 1].a), ans);
            }
            sb.append(ans + "\n");
        }
        System.out.println(sb);
        s.close();
    }
}
