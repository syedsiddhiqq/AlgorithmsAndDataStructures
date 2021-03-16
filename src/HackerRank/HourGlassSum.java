package HackerRank;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 20/12/2020, Sunday, 07:19
 * https://www.hackerrank.com/challenges/2d-array/problem
 */
public class HourGlassSum {
	static int findSum(int[][] arr, int row, int col) {
		int sum = 0,rowIndex = row+1,colIndex = col+2;
		for (int i = row; i < row + 3; i++) {
			for (int j = col; j < col + 3; j++) {
				if(!((i == rowIndex && j == col) || (i == rowIndex && j == colIndex))){
					sum+=arr[i][j];
				}
			}
		}
		return sum;
	}

	static int hourglassSum(int[][] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int sum = findSum(arr, i, j);
//				System.out.println("i::"+i+",j::"+j+",sum::"+sum);
				if (max < sum) {
					max = sum;
				}
			}
		}
		return max;
	}

	static int[][] getInput(){
		Scanner scanner = new Scanner(System.in);
		int[][] arr = new int[6][6];
		for(int i=0;i<6;i++)
			for(int j=0;j<6;j++)
				arr[i][j] = scanner.nextInt();
		return arr;
	}

	public static void main(String[] args) {
		System.out.println(hourglassSum(getInput()));
	}
}
