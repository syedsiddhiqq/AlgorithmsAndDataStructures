//package CodeForces.RoadMap.Diff1300;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 17/09/2021, Friday, 19:17
 */
public class NumberOfPairsSolution {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int T = scanner.nextInt();

		for (int t = 0; t < T; t ++) {
			int n = scanner.nextInt(), l = scanner.nextInt(), r = scanner.nextInt();
			long ans = 0;
			Integer[] a = new Integer[n];
			for (int i = 0; i < n; i ++) a[i] = scanner.nextInt();
			Arrays.sort(a);
			for (int i = 0; i < n; i ++) {
				int lb = l - a[i], ub = r - a[i];
				int low = lower_bound(a, i, lb), high = upper_bound(a, i, ub);
				ans += high - low;
			}
			System.out.println(ans);
		}
	}

	static int lower_bound (Integer[] arr, int up, int x) {
		int low = 0, high = up, mid = -1;

		while (low < high) {
			mid = (low + high) / 2;
			if (arr[mid] >= x) high = mid;
			else low = mid + 1;
		}
		return low;
	}

	static int upper_bound (Integer[] arr, int up, int x) {
		int low = 0, high = up, mid = -1;

		while (low < high) {
			mid = (low + high) / 2;
			if (arr[mid] > x) high = mid;
			else low = mid + 1;
		}
		return low;
	}
}
