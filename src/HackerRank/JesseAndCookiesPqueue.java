package HackerRank;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 16/03/2021, Tuesday, 23:51
 */
public class JesseAndCookiesPqueue {

	static int cookies(int k, int[] A) {
		Queue<Integer> queue = new PriorityQueue<>();
		for (int value : A) queue.add(value);
		int operation = 0;

		while (!queue.isEmpty() && queue.peek() > k) {
			operation++;
			int firstCookie = queue.poll();
			int secondCookie = queue.isEmpty() ? 0 : 2 * queue.poll();
			queue.add(firstCookie + secondCookie);
		}
		if(operation == 0) return -1;
		return operation;
	}


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n, k;
		n = scanner.nextInt();
		k = scanner.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}


	}
}
