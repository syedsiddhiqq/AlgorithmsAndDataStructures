package CodeForces.contests.div3contest787;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 05-05-2022, Thursday, 21:24
 */
public class ReplaceWithPrevV2 {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt(), k = s.nextInt();

        char[] str = s.next().toCharArray();

        int[] dp = new int[26];

        for (int i = 0; i < 26; i++) dp[i] = i;

        Character curr = null;
        for (int i = 0; i < n && k > 0; i++) {
            if (str[i] != 'a' && dp[str[i] - 'a'] > 0) {
                curr = str[i];
                while (k-- > 0 && curr > 'a' && dp[curr - 'a'] > 0) {
                    curr--;
                }
                k++;
                int minCh = Math.min(curr - 'a', dp[curr - 'a']);
                for (int j = str[i] - 'a'; j >= 0; j--) {
                    dp[j] = Math.min(dp[j], minCh);
                }
            }
        }

//        dp[25] = 25;
//        for (int i = 24; i >= 0; i--) {
//            dp[i] = Math.min(dp[i], dp[i + 1]);
//        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append((char) (dp[str[i] - 'a'] + 'a'));
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
