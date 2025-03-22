package CodeForces.RoadMap.Diff1400;

import com.sun.security.jgss.GSSUtil;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 30-04-2022, Saturday, 08:49
 */
public class PalindromesColoring {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt(), k = s.nextInt();
        char[] str = s.next().toCharArray();

        int[] freq = new int[26];

        int countEven = 0, countOdd = 0;

        for (int i = 0; i < n; i++) {
            char ch = str[i];
            freq[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                if (freq[i] % 2 == 0) {
                    countEven += freq[i];
                } else {
                    if (freq[i] > 1) {
                        countEven += freq[i] - 1;
                    }else if(freq[i] == 1){
                        countOdd++;
                    }
                }
            }
        }

        int total = countOdd > 0 ? countEven + 1 : countEven;
        int ans = total / k;
        System.out.println(ans > 0 ? ans : 1);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
