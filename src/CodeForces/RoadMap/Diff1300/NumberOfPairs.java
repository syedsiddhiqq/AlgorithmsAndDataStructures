//package CodeForces.RoadMap.Diff1300;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 17/09/2021, Friday, 17:09
 */
public class NumberOfPairs {
	private static Scanner fs = new Scanner(System.in);

	private static int lowerBound(Integer[] a, int start, int end, int x) {
		while (start < end) {
			int m = (start + end) >>> 1;
			if (a[m] >= x) end = m;
			else start = m + 1;
		}
		return start;
	}

	private static int upperBound(Integer[] a, int start, int end, int x) {
		while (start < end) {
			int m = (start + end) >>> 1;
			if (a[m] > x) end = m;
			else start = m + 1;
		}
		return start;
	}

	private static void solve() {
		int n, l, r;
		n = fs.nextInt();
		l = fs.nextInt();
		r = fs.nextInt();

		Integer[] arr = new Integer[n];

		for (int i = 0; i < n; i++) arr[i] = fs.nextInt();
		Arrays.sort(arr);

		long ans = 0;
		for (int i = 0; i < n; i++) {
			int lowerBound = lowerBound(arr, 0, i, l - arr[i]);
			int upperBound = upperBound(arr, 0, i, r - arr[i]);
			ans += upperBound - lowerBound;
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		int t = fs.nextInt();
		while (t-- > 0) {
			solve();
		}
	}
}
