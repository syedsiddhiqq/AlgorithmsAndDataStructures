package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 16-04-2022, Saturday, 10:05
 */
public class SocialDistance {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt(), k = s.nextInt();
        char[] str = s.next().toCharArray();

        int count = 0;
        for (int i = 0; i < n; ) {
            if (str[i] == '0') {
                int j = i + k + 1;
                boolean ok = true;
                int failureIndex = -1;
                j = j < n ? j : n - 1;
                while (j < n && j > i) {
                    if (str[j] == '1') {
                        ok = false;
                        failureIndex = j;
                        break;
                    }
                    j--;
                }
                if (ok) {
                    str[i] = '1';
                    count++;
                    i = i + (2 * k) + 1;
                } else {
                    i = failureIndex + k + 1;
                }
            } else {
                i = i + k + 1;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
