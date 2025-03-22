package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 04-04-2022, Monday, 09:49
 */
public class PerformTheCombo {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt(), m = s.nextInt();
        char[] str = s.next().toCharArray();
        long[] freq = new long[27];
        Map<Character, List<Integer>> indices = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            freq[str[i] - 'a']++;
            char ch = str[i];
            if (indices.containsKey(ch)) {
                indices.get(ch).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                indices.put(ch, list);
            }
        }
        int[] arr = new int[m];
        Map<Integer, Long> count = new HashMap<>();

        for (int i = 0; i < m; i++) {
            arr[i] = s.nextInt();
            count.put(arr[i], count.getOrDefault(arr[i], 0L) + 1);
        }


        for (Integer key : count.keySet()) {
            long countVal = count.get(key);
            for (int i = 0; i < 26; i++) {
                char ch = (char) ('a' + i);
                if (indices.containsKey(ch)) {
                    long countOfCh = indices.get(ch).stream().filter(k -> k < key).count();
                    freq[ch - 'a'] = freq[ch - 'a'] + (countOfCh * countVal);
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(freq[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
