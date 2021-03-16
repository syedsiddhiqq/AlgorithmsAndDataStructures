package GFG;

/**
 * @author Syed Ali.
 * @createdAt 22/02/2021, Monday, 01:02
 */

import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException {
		BufferedReader br =
				new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			String[] str = br.readLine().trim().split(" ");
			int[] array = new int[n - 1];
			for (int i = 0; i < n - 1; i++) {
				array[i] = Integer.parseInt(str[i]);
			}
//			TrappingWaterSolution sln = new TrappingWaterSolution();
//			System.out.println(sln.MissingNumber(array, n));
		}
	}
}// } Driver Code Ends


// User function Template for Java

class Solution {
	int MissingNumber(int array[], int n) {
		int total = (n *  (n+1))/2;
		int sum = 0;
		for(int i=0;i<n;i++) sum += array[i];
		return total - sum;
	}
}