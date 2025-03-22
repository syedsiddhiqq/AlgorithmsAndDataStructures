package CodeForces.RoadMap.Diff1400;

import java.util.*;
import java.io.*;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author SyedAli
 * @createdAt 01-05-2022, Sunday, 09:41
 */
public class PerfectlyBalancedString {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        char[] str = s.next().toCharArray();
        int n = str.length;

        if (n <= 2) {
            System.out.println("YES");
        } else {
            Set<Character> set = new HashSet<>(str[0]);
            boolean invalid = false;
            for (int i = 1; i < n; i++) {
                set.add(str[i]);
                if (str[i] == str[i - 1]) {
                    invalid = true;
                }
            }

            if (invalid && set.size() > 1) {
                System.out.println("NO");
                return;
            }


            for (int i = 0; i < n - 2; i++) {
                Set<Character> temp = new HashSet<>();
                temp.add(str[i]);
                temp.add(str[i + 1]);
                temp.add(str[i + 2]);
                if (temp.size() == 2 && temp.size() != set.size()) {
                    System.out.println("NO");
                    return;
                }
            }
            System.out.println("YES");
        }
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
