package Algorithms.others;

import Common.Fs;

/**
 * @author Syed Ali.
 * @createdAt 22/03/2021, Monday, 07:38
 */
public class GCD {
	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	public static void main(String[] args) {
		Fs fs = new Fs();
		int t = fs.nextInt();
		while (t-- > 0) {
			int a = fs.nextInt();
			int b = fs.nextInt();

			System.out.println(gcd(a, b));
		}
	}
}
