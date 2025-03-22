package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 24-04-2022, Sunday, 19:00
 */
public class FromStoTv1 {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        char[] initial = s.next().toCharArray();
        char[] t = s.next().toCharArray();
        char[] p = s.next().toCharArray();
        int[] pFreq = new int[26];

        for (int i = 0; i < p.length; i++) pFreq[p[i] - 'a']++;

        int sStart = 0, tStart = 0;
        while (tStart < t.length && sStart < initial.length) {
            if (initial[sStart] == t[tStart]) {
                sStart++;
                tStart++;
                continue;
            }

            if (pFreq[t[tStart] - 'a'] > 0) {
                pFreq[t[tStart] - 'a']--;
                tStart++;
            } else {
                System.out.println("NO");
                return;
            }
        }
        if (sStart < initial.length) {
            System.out.println("NO");
            return;
        }

        while (tStart < t.length) {
            if (pFreq[t[tStart] - 'a'] > 0) {
                pFreq[t[tStart] - 'a']--;
                tStart++;
            } else {
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
