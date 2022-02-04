//package CodeForces.contests.contestdiv31619;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 20/12/2021, Monday, 19:59
 */
public class B {
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			long n = scan.nextInt();
			long k = (long) Math.sqrt(n);
			long m = (long) Math.cbrt(n);
			long p = (long) Math.sqrt(m);
			System.out.println(k + m - p);
		}
	}
}
