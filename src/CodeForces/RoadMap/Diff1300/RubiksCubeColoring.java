package CodeForces.RoadMap.Diff1300;

import java.util.*;

/**
 * @author SyedAli
 * @createdAt 10-04-2022, Sunday, 18:58
 */
public class RubiksCubeColoring {
    private static Scanner s = new Scanner(System.in);

    private static long mod = 1000000007;

    private static long binPow(long a, long b) {
        if (b == 0)
            return 1;
        long res = binPow(a, b / 2) % mod;
        res = (res * res) % mod;
        if (b % 2 == 1)
            return res * a;
        else
            return res;
    }

    private static void solve() {
        int k = s.nextInt();
        long nodes = (long) Math.pow(2, k) - 2;
        // long nodes1 = binPow(2, k) - 2;
        long ans = binPow(4, nodes) % mod;
        ans = (ans * 6) % mod;
        System.out.println(ans);
    }

    public static void main(String[] args) {
        solve();
    }
}
