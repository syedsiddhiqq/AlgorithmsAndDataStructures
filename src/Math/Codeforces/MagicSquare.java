//package Math.Codeforces;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 29/03/2021, Monday, 22:38
 * https://codeforces.com/contest/259/problem/B
 *
 * Note that a+b+c+d+e+f+x+y+z = 3s where s is the sum of a line. But x+y+z = s, so a+b+c+d+e+f = 2s. Aka the total
 * sum of the numbers given is 2s. Divide by 2 to get s.
 *
 * Now the rest is easy: x = s-a-b, y = s-c-d, z = s-e-f.
 */
public class MagicSquare {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[][] square = new int[3][3];
		int sum = 0;
		int s ;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				square[i][j] = scanner.nextInt();
				sum+=square[i][j];
			}
		}

		s = sum/2;

		square[0][0] = s - (square[0][1] + square[0][2]);
		square[1][1] = s - (square[1][0] + square[1][2]);
		square[2][2] = s - (square[2][0] + square[2][1]);

		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				System.out.print(square[i][j] + " ");
			}
			System.out.println();
		}
	}
}
