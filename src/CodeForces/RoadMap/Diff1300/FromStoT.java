package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 24-04-2022, Sunday, 18:52
 */
public class FromStoT {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        char[] initial = s.next().toCharArray();
        char[] t = s.next().toCharArray();
        char[] p = s.next().toCharArray();

        int[] freqP = new int[27];
        for (int i = 0; i < p.length; i++) {
            freqP[p[i] - 'a']++;
        }

        int[] freqT = new int[27];
        for (int i = 0; i < t.length; i++) {
            freqT[t[i] - 'a']++;
        }

        int[] freqS = new int[27];
        for (int i = 0; i < initial.length; i++) {
            freqS[initial[i] - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freqS[i] <= freqT[i]) {
                int diff = freqT[i] - freqS[i];
                if (freqP[i] <= diff) {
                    System.out.println("NO");
                    return;
                }
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
