package CodeForces.RoadMap.Diff1300;

import java.util.Scanner;

/**
 * @author SyedAli
 * @createdAt 17-04-2022, Sunday, 09:35
 */
public class BuyingShowels {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt(), k = s.nextInt();

        if (n <= k) {
            System.out.println("1");
        } else if (n % 2 == 0 && n / 2 <= k) {
            System.out.println(2);
        } else {
            long ans = n;
            for (int i = 1; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    if (i <= k) ans = Math.min(ans, n / i);
                    if (n / i <= k) ans = Math.min(ans, i);
                }
            }
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
