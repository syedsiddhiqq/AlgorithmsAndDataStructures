//package CodeForces.RoadMap.Diff1300;

import java.util.*;

/**
 * @author Syed Ali.
 * @createdAt 21/09/2021, Tuesday, 20:39
 */
public class MakePowerOfTwo {
	private static Scanner s = new Scanner(System.in);

	private static List<char[]> powersOfTwo = new ArrayList<>();

	private static int operationsRequired(char[] inputStr, char[] powerOfTwo) {
		int taken = 0, i = 0, j = 0;
		while (i < inputStr.length && j < powerOfTwo.length) {
			if (inputStr[i] == powerOfTwo[j]) {
				++taken;
				++j;
			}
			++i;
		}
		return inputStr.length - taken + powerOfTwo.length - taken;
	}

	private static void solve() {
		char[] str = s.next().toCharArray();
		int answer = str.length + 1;
		for (char[] powerOfTwo : powersOfTwo) {
			answer = Math.min(answer, operationsRequired(str, powerOfTwo));
		}
		System.out.println(answer);
	}

	public static void main(String[] args) {
		long size = (long) 2e18;
		for (long p = 1; p <= size; p *= 2) powersOfTwo.add(String.valueOf(p).toCharArray());
		int t = s.nextInt();
		while (t-- > 0) {
			solve();
		}
	}
}
