package codechef.starters14;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 29/09/2021, Wednesday, 21:44
 */
public class OddGcd {
	private static Scanner s = new Scanner(System.in);

	private static int gcd(int a, int b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}

	private static int findGCD(List<Integer> arr, int n) {
		int result = arr.get(0);
		for (int i = 1; i < n; i++) {
			result = gcd(arr.get(i), result);

			if (result == 1) {
				return 1;
			}
		}
		return result;
	}

	private static void solve() {
		int n = s.nextInt();
		Queue<Integer> queue = new PriorityQueue<>();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int temp = s.nextInt();
			queue.add(temp);
			list.add(temp);
		}

		int gcd = findGCD(list, n);
		int moves = 0;
		while (gcd % 2 == 0) {
			boolean oddFound = false;
			List<Integer> temp = new ArrayList<>();
			while (!queue.isEmpty()) {
				Integer i = queue.poll();
				Integer floorValue = Math.floorDiv(i, 2);
				if (floorValue % 2 == 1) {
					++moves;
					oddFound = true;
					temp.add(floorValue);
					break;
				} else {
					temp.add(i);
				}
			}

			if (!oddFound && temp.size() > 0) {
				++moves;
				temp.add(0, Math.floorDiv(temp.get(0), 2));
			}

			queue.addAll(temp);
			gcd = findGCD(temp, temp.size());
		}
		System.out.println(moves);
	}

	public static void main(String[] args) {
		int t = s.nextInt();
		while (t-- > 0) {
			solve();
		}
	}
}
