package CodeForces.RoadMap.Diff1300;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 20/06/2021, Sunday, 08:14
 */
public class Shuffle {
    static Scanner fs = new Scanner(System.in);

    static void solve() {
        long n;
        int x, m;
        n = fs.nextLong();
        x = fs.nextInt() - 1;
        m = fs.nextInt();
        int max = x, min = x;
        for (int i = 0; i < m; i++) {
            int left = fs.nextInt() - 1;
            int right = fs.nextInt() - 1;

            if (left > max || right < min) {
                continue;
            }
            max = Math.max(max, right);
            min = Math.min(min, left);
        }
        System.out.println(max - min + 1);
    }

    public static void main(String[] args) {
        int t = fs.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
