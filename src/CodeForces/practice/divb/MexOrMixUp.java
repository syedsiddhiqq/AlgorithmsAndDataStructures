package CodeForces.practice.divb;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 14/09/2021, Tuesday, 08:14
 */
public class MexOrMixUp {
	private static Scanner s = new Scanner(System.in);
	private static int size = (int) (3 * Math.pow(10, 5));
	private static int[] dp = new int[size + 1];

	private static void dp() {
		dp[0] = 0;
		for (int i = 1; i <= size; i++) {
			dp[i] = dp[i - 1] ^ i;
		}
	}

	private static void solve() {
		int a = s.nextInt();
		int b = s.nextInt();

		if (dp[a - 1] == b) {
			System.out.println(a);
		} else if ((dp[a - 1] ^ a) == b) {
			System.out.println(a + 2);
		} else {
			System.out.println(a + 1);
		}
	}

	public static void main(String[] args) {
		int t = s.nextInt();
		dp();
		while (t-- > 0) {
			solve();
		}
	}

}
