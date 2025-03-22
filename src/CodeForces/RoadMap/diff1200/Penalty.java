package CodeForces.RoadMap.diff1200;

import java.util.*;

/**
 * @author Syed Ali.
 * @createdAt 11/08/2021, Wednesday, 16:33
 */
public class Penalty {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        char[] str = s.next().toCharArray();
        int[] a = new int[6];
        int[] b = new int[6];

        // Assigning goals to a and b.
        int aStart = 1, bStart = 1;
        for (int i = 0; i < str.length; i++) {
            if (i % 2 == 0) {
                a[aStart++] = str[i] == '?' ? 1 : str[i] == '0' ? 0 : 1;
            } else {
                b[bStart++] = str[i] == '?' ? 1 : str[i] == '0' ? 0 : 1;
            }
        }

        for (int i = 1; i <= 5; i++) {
            a[i] += a[i - 1];
            b[i] += b[i - 1];
            int goals = Math.min(a[i], b[i]) + (5 - i);
            if (goals >= Math.max(a[i], b[i])) continue;
            if (a[i] > b[i]) {
                System.out.println(2 * i - 1);
            } else {
                System.out.println(2 * i);
            }
			return;
        }
		System.out.println(10);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
