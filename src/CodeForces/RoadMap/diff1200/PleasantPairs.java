//package CodeForces.RoadMap.diff1200;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 08/07/2021, Thursday, 12:46
 */
public class PleasantPairs {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for (int t = 0; t < testCases; t++) {
			int n = scanner.nextInt();
			long[] arr = new long[n + 1];
			for (int i = 1; i <= n; i++) {
				arr[i] = scanner.nextInt();
			}

			int answer = 0;
			for (int i = 1; i <= n; i++) {
				for (int j = (int) arr[i] - i; j <= n; j += arr[i]) {
					if (j >= 0) {
						if (arr[i] * arr[j] == i + j && i < j) {
							++answer;
						}
					}
				}
			}
			System.out.println(answer);
		}
	}
}
