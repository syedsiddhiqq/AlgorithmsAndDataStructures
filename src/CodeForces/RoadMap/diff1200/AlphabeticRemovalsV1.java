package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 30-03-2022, Wednesday, 22:09
 */
public class AlphabeticRemovalsV1 {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt(), k = s.nextInt();
        Map<Character, Integer> freq = new HashMap<>();
        char[] str = s.next().toCharArray();
        for (int i = 0; i < n; i++) {
            char ch = str[i];
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < 26 && k > 0; i++) {
            char ch = (char) ('a' + i);
            if (freq.containsKey(ch)) {
                int toRemove = Math.min(k, freq.get(ch));
                k -= toRemove;
                freq.put(ch, freq.get(ch) - toRemove);
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            char ch = str[i];
            if (freq.get(ch) < 1) {
                str[i] = '-';
            } else {
                freq.put(ch, freq.get(ch) - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (str[i] != '-')
                System.out.print(str[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        solve();
    }
}
