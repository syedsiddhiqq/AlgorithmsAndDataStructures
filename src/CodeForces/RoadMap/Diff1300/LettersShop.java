package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 25-04-2022, Monday, 09:40
 */
public class LettersShop {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        char[] input = s.next().toCharArray();
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = input[i];
            if (map.containsKey(ch)) {
                map.get(ch).add(i);
            } else {
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                map.put(ch, indices);
            }
        }

        int m = s.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            char[] name = s.next().toCharArray();
            int[] index = new int[26];

            int max = Integer.MIN_VALUE;
            for (int j = 0; j < name.length; j++) {
                char ch = name[j];
                max = Math.max(max, map.get(ch).get(index[ch - 'a']++));
            }
            sb.append((max+1) + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        solve();
        s.close();
    }
}
