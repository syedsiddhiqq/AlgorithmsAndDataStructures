package CodeForces.RoadMap.Diff1400;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 18-05-2022, Wednesday, 09:58
 */
public class StringEquality {
    private static Scanner s = new Scanner(System.in);

    private static boolean check(char[] a, char[] b, int start, int k) {
        for (int i = start + 1; i < start + k && i < a.length; i++) {
            if (a[i] != a[i - 1] || b[i] != b[i - 1] || a[i] == 'z' || a[i - 1] == 'z') return false;
        }
        return true;
    }

    private static void solve() {
        int n = s.nextInt(), k = s.nextInt();

        char[] a = s.next().toCharArray();
        char[] b = s.next().toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0;
        while (i < n) {
            if (a[i] != b[i]) {
                boolean invalid = false;
                if (a[i] <= b[i]) {
                    if (!check(a, b, i, k)) {
                        invalid = true;
                    } else {
                        i += k;
                        continue;
                    }
                } else {
                    invalid = true;
                }
                if (invalid) {
                    System.out.println("NO");
                    return;
                }
            }
            i++;
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
