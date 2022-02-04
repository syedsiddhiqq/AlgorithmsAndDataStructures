package ArganoKeste;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 10/12/2021, Friday, 17:58
 */
public class PatternPrintingV2 {

	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int n = s.nextInt();
		char[][] pattern = new char[n][n];

		for(int i = 0 ; i < n ; i++) {

			if(i < n/2) {
				for(int j = 0 ; j <=i ; j++) {
					pattern[i][j] = '*';
					pattern[i][n-1-j] = '*';
				}
			}
			else {
				for(int j = 0 ; j < n-i ; j++) {
					pattern[i][j] = '*';
					pattern[i][n-1-j] = '*';
				}
			}

		}

		for(int i = 0; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				System.out.print(pattern[i][j]);
			}
			System.out.println();
		}
	}
}
