package CodeForces.practice.divb;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 14/09/2021, Tuesday, 10:45
 */
public class MinMexCut {
	private static Scanner s = new Scanner(System.in);

	private static void solve() {
		char[] str = s.next().toCharArray();
		int length = str.length;
		int countOfZero = 0, countOfOne = 0, countOfZeroSubStrings = 0;
		for (int i = 0; i < length; i++) {
			if (str[i] == '0') {
				++countOfZero;
				if (i == 0 || str[i - 1] != '0') ++countOfZeroSubStrings;
			} else if (str[i] == '1') {
				++countOfOne;
			}
		}
		if (countOfZero == 0) {
			System.out.println("0");
		} else if (countOfOne == 0) {
			System.out.println("1");
		} else {
			System.out.println(Math.min(2, countOfZeroSubStrings));
		}
	}

	public static void main(String[] args) {
		int t = s.nextInt();
		while (t-- > 0) {
			solve();
		}
	}
}
