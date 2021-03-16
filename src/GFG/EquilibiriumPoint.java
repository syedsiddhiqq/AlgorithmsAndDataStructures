package GFG;

/**
 * @author Syed Ali.
 * @createdAt 24/02/2021, Wednesday, 03:39
 */
// { Driver Code Starts

import java.io.*;
import java.util.*;

class EquilibiriumPoint {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
		while (t-- > 0) {

			//taking input n
			int n = Integer.parseInt(br.readLine().trim());
			long arr[] = new long[n];
			String inputLine[] = br.readLine().trim().split(" ");

			//adding elements to the array
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(inputLine[i]);
			}

			EquilibriumSubClass ob = new EquilibriumSubClass();

			//calling equilibriumPoint() function
			System.out.println(ob.equilibriumPoint(arr, n));
		}
	}
}// } Driver Code Ends

class EquilibriumSubClass {

	// a: input array
	// n: size of array
	// Function to find equilibrium point in the array.
	public static int equilibriumPoint(long arr[], int n) {
		if(n == 1) return 0;
		long[] dp = new long[n];
		dp[0] = arr[0];
		for(int i=1;i<n;i++){
			dp[i] = arr[i] + dp[i-1];
		}

		for(int i = 1;i<n;i++){
			if(dp[i-1] == dp[n-1] - dp[i]){
				return i+1;
			}
		}
		return -1;
	}
}

