//package CodeForces.RoadMap.Diff1300;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 18/09/2021, Saturday, 12:28
 */
public class StrangeBirthdayParty {
	private static Scanner s = new Scanner(System.in);

	private static void solve() {
		int n = s.nextInt(), m = s.nextInt();
		Integer[] arr = new Integer[n], cost = new Integer[m];
		for (int i = 0; i < n; i++) arr[i] = s.nextInt();
		for (int i = 0; i < m; i++) cost[i] = s.nextInt();
		Arrays.sort(arr);
		int j = 0;
		long answer = 0;
		for (int i = n-1; i >= 0; i--) {
			if (j < m) {
				if (cost[j] < cost[arr[i] - 1]) {
					answer += cost[j];
					j++;
				} else {
					answer += cost[arr[i] - 1];
				}
			} else {
				answer += cost[arr[i] - 1];
			}
		}
		System.out.println(answer);
	}

	public static void main(String[] args) {
		int t = s.nextInt();
		while (t-- > 0) {
			solve();
		}
	}
}
