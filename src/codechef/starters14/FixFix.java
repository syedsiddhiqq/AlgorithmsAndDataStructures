package codechef.starters14;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 29/09/2021, Wednesday, 20:36
 */
public class FixFix {
	private static Scanner s = new Scanner(System.in);

	private static void solve() {
		int n = s.nextInt();
		int k = s.nextInt();
		StringBuilder s = new StringBuilder();
		if (n - k == 1) {
			s.append("-1");
		} else if (n == k) {
			for (int i = 1; i <= n; i++) {
				s.append(i).append(" ");
			}
		} else {
			for (int i = 1; i <= k; i++) {
				s.append(i).append(" ");
			}

			for (int i = k + 2; i <= n; i++) {
				s.append(i).append(" ");
			}

			s.append(k + 1).append(" ");
		}
		s.append("\n");
		System.out.print(s.toString());
	}

	public static void main(String[] args) {
		int t = s.nextInt();
		while (t-- > 0) {
			solve();
		}
	}
}
