package CodeForces.contests.div3contest787;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 05-05-2022, Thursday, 21:22
 */
public class ReplaceWithPrevV1 {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt(), k = s.nextInt();

        char[] str = s.next().toCharArray();


        Character curr = null;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < n && k > 0; i++) {
            if (str[i] != 'a') {
                curr = str[i];
                while (k-- > 0 && curr > 'a') {
                    curr--;
                }
                map.put(str[i], curr);
                str[i] = curr;
            }
        }
        System.out.println(str);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
