package CodeForces.contests.contest783Div2;

import java.util.*;

/**
 * @author SyedAli
 * @createdAt 19-04-2022, Tuesday, 20:02
 */
public class DirectionChange {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt(), m = s.nextInt();
        if ((n == 1 && m > 2) || (m == 1 && n > 2)) {
            System.out.println(-1);
        } else {
            int ans = 2 * Math.min(n, m) - 2;
            ans += 2 * (Math.max(n, m) - Math.min(n, m));
            if ((Math.max(n, m) - Math.min(n, m)) % 2 == 1) ans--;
            System.out.println(ans);
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
