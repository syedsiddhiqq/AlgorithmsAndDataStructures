package ArganoKeste;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Syed Ali.
 * @createdAt 18/10/2021, Monday, 16:04
 */
public class FindMinChoice {
	public int solve(Integer[] arr, int k) {
		int length = arr.length;
		int count = -1;
		Boolean[] visited = new Boolean[length];
		Arrays.sort(arr, Collections.reverseOrder());
		Arrays.fill(visited, false);
		for (int i = 0; i < length; i++) {
			visited[i] = true;
			if (arr[i] == k) {
				count = 1;
				break;
			} else {
				return findMinChoice(arr, 1, k, 0, length,visited);
			}
		}
		return count;
	}


	public int findMinChoice(Integer[] arr, int count, int k, int sum, int length, Boolean[] visited) {
		if (sum > k) return -1;
		if (sum == k) return count;
		if (sum < k) {
			for (int j = 0; j < length; j++) {
				if (!visited[j]) {
					visited[j] = true;
					int temp = findMinChoice(arr, count + 1, k, sum + arr[j], length, visited);
					if (temp > 0) return temp;
					visited[j] = false;
				}
			}
		}
		return 0;
	}


}
