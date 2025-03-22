package CodeForces.contests.div3contest787;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 05-05-2022, Thursday, 21:02
 */
public class ReplaceWithPrev {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt(), k = s.nextInt();

        char[] str = s.next().toCharArray();
        Map<Character, Boolean> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(str[i], true);
        }


        Character curr = null;
        for (int i = 0; i < n && k > 0; i++) {
            if (str[i] != 'a') {
                curr = str[i];
                while (k-- > 0 && curr > 'a') {
                    map.put(curr, false);
                    curr--;
                }
                str[i] = curr;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
            if (map.get(str[j])) {
                sb.append(str[j]);
            } else {
                sb.append(curr);
            }
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
