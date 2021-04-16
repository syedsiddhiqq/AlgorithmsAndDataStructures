package CodeForces.RoadMap.D2_C1;

import java.util.Scanner;
/**
 * @author Syed Ali.
 * @createdAt 17/04/2021, Saturday, 01:45
 */
public class CookieForYou {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; ++tc) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			long n = sc.nextLong();
			long m = sc.nextLong();

			System.out.println(solve(a, b, n, m) ? "Yes" : "No");
		}
		sc.close();
	}

	static boolean solve(long a, long b, long n, long m) {
		return n + m <= a + b && m <= Math.min(a, b);
	}
}
