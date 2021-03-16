package HackerRank;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 16/03/2021, Tuesday, 16:25
 */
public class QheapWithPriorityQueue {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Queue<Integer> minHeap = new PriorityQueue<>();

		int q = scanner.nextInt();
		scanner.nextLine();

		for (int i = 0; i < q; i++) {
			String query = scanner.nextLine().trim();
			char type = query.charAt(0);

			if (query.length() > 1) {
				int num = Integer.parseInt(query.substring(2));
				if (type == '1') {
					minHeap.add(num);
				} else if (type == '2') {
					minHeap.remove(num);
				}
			} else {
				System.out.println(minHeap.peek());
			}
		}

		scanner.close();
	}
}
