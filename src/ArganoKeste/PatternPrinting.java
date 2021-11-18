package ArganoKeste;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 29/09/2021, Wednesday, 12:24
 */
public class PatternPrinting {
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int n = s.nextInt();
		char[][] pattern = new char[n][n];
		int aPointer = -1, bPointer = n / 2 - 1;
		for (int i = 0; i < n; i++) {
			if (++aPointer < n / 2) {
				for (int j = 0; j <= aPointer; j++) {
					pattern[i][j] = '*';
					pattern[i][n - j - 1] = '*';
				}
			} else {
				for (int j = bPointer; j >= 0; j--) {
					pattern[i][j] = '*';
					pattern[i][n - j - 1] = '*';
				}
				bPointer--;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(pattern[i][j]);
			}
			System.out.println();
		}
	}
}
