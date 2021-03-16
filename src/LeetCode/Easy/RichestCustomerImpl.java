package LeetCode.Easy;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 14/12/2020, Monday, 13:48
 * https://leetcode.com/problems/richest-customer-wealth/
 */
public class RichestCustomerImpl {
	public static class RichestCustomer{
		public int maximumWealth(int[][] accounts) {
			int max = Integer.MIN_VALUE,sum;
			for(int i=0;i<accounts.length;i++){
				sum = 0;
				for (int j = 0; j < accounts[i].length; j++) {
					sum+=accounts[i][j];
				}
				if(sum>=max) sum = max;
			}
			return max;
		}
	}
	public static void main(String[] args) {
		int m,n;
		Scanner scanner = new Scanner(System.in);
		m = scanner.nextInt();
		n = scanner.nextInt();
		int[][] arr = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = scanner.nextInt();
			}
		}
		RichestCustomer richestCustomer = new RichestCustomer();
		System.out.println(richestCustomer.maximumWealth(arr));
	}
}
