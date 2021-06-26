package CodeForces.RoadMap.Diff1400;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 06/06/2021, Sunday, 13:30
 */
public class ZeroRemainderArray {
	static Scanner fs = new Scanner(System.in);

	static private void solve() {
		int n, k, answer = 0;
		n = fs.nextInt();
		k = fs.nextInt();
		int[] arr = new int[n];
		int max = 1;
		Map<Integer, Integer> data = new HashMap<>();
		for (int i = 0; i < n; i++) {
			arr[i] = fs.nextInt();
			if (arr[i] % k != 0) {
				int t = k - arr[i] % k;
				data.put(t, data.getOrDefault(t, -1) + 1);
				max = Math.max(max, data.get(t));
			}
		}

		for (Integer key : data.keySet()) {
			if (data.get(key) == max) {
				answer = k * (data.get(key) - 1) + key + 1;
			}
		}

		System.out.println(answer);
	}

	public static void main(String[] args) {
		int t = fs.nextInt();
		while (t-- > 0) {
			solve();
		}
	}
}
