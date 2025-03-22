package CodeForces.RoadMap.Diff1400;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 01-05-2022, Sunday, 20:39
 */

public class PalindromeBasis {
    static int idx = 0;
    static int[] pals = new int[498];

    static void genPal() {
        for (int i = 1; i < 10; i++) {
            pals[idx++] = i;
            pals[idx++] = i * 10 + i;
            for (int j = 0; j < 10; j++) {
                pals[idx++] = i * 100 + j * 10 + i;
                pals[idx++] = i * 1000 + j * 100 + j * 10 + i;
                if (i > 3) continue;
                for (int k = 0; k < 10; k++)
                    pals[idx++] = i * 10000 + j * 1000 + k * 100 + j * 10 + i;
            }
        }
    }

    public static void main(String[] args) {
        genPal();
        int[] dp = new int[40001];
        dp[0] = 1;
        for (int i = 0; i < 498; i++) {
            for (int j = 0; j < 40001; j++) {
                if (pals[i] <= j) dp[j] += dp[j - pals[i]];
                dp[j] %= 1000000007;
            }
        }
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            System.out.println(dp[sc.nextInt()]);
        }
    }
}