package CodeForces.RoadMap.Diff1300;

import java.util.*;

/**
 * @author SyedAli
 * @createdAt 07-04-2022, Thursday, 08:38
 */
public class GoodNumbers {
    private static Scanner s = new Scanner(System.in);

    private static int[] dp = new int[11];

    private static void pre() {
        dp[0] = 1;
        for (int i = 1; i < 11; i++) {
            dp[i] = dp[i - 1] * 3;
        }
    }

    public static int lowerBound(int x) {
        int low = -1;
        int high = dp.length;
        while (high - low > 1) {
            int middle = (low + high) / 2;
            if (dp[middle] <= x) {
                low = middle;
            } else {
                high = middle;
            }
        }
        return low;
    }

    private static void solve() {
        int n = s.nextInt();
        int copy = n;
        List<Integer> powers = new ArrayList<>();
        while (n > 0) {
            int power = lowerBound(n);
            if (powers.contains(power)) {
                int sum = 0;
                for (int i = powers.get(0); i >= 0; i--) {
                    sum += dp[i];
                    if (sum >= copy) {
                        System.out.println(sum);
                        return;
                    }
                }
                System.out.println(dp[powers.get(0) + 1]);
                return;
            }
            powers.add(power);
            n = n - dp[power];
        }
        System.out.println(copy);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        pre();
        while (t-- > 0) {
            solve();
        }
    }
}
