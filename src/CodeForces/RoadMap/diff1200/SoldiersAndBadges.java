//package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 24-03-2022, Thursday, 09:05
 */
public class SoldiersAndBadges {

    private static Scanner s = new Scanner(System.in);

    private static int findNextZeroFreq(int[] freq, int start) {
        for (int j = start; j <= 6200; j++) {
            if (freq[j] == 0) {
                return j;
            }
        }
        return -1;
    }


    private static void solve() {
        int n = s.nextInt();
        int[] arr = new int[n + 1];
        int[] freq = new int[6200];
        for (int i = 1; i <= n; i++) {
            arr[i] = s.nextInt();
            freq[arr[i]]++;
        }

        int lastFoundZeroFreq = 0, ans = 0;
        for (int i = 1; i <= n; i++) {
            lastFoundZeroFreq = Math.max(lastFoundZeroFreq, i);
            if (freq[i] > 1) {
                int countToRemove = freq[i] - 1;
                while (countToRemove-- > 0) {
                    lastFoundZeroFreq = findNextZeroFreq(freq, lastFoundZeroFreq + 1);
                    freq[lastFoundZeroFreq] = 1;
                    ans += lastFoundZeroFreq - i;
                }
                freq[i] = 1;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        solve();
    }
}
