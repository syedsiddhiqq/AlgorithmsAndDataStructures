package codechef.starters14;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 29/09/2021, Wednesday, 20:18
 */
public class DiagonalMovement {
	private static Scanner s = new Scanner(System.in);

	private static void solve() {
		int x = s.nextInt(), y = s.nextInt();
		x = Math.abs(x);
		y = Math.abs(y);
		if ((x % 2 == 0 && y % 2 == 0) || (x % 2 == 1 && y % 2 == 1)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	public static void main(String[] args) {
		int t = s.nextInt();
		while (t-- > 0) {
			solve();
		}
	}
}
