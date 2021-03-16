package GFG;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 22/02/2021, Monday, 00:51
 */


class KadaneProblem {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
			//size of array
			int n = Integer.parseInt(br.readLine().trim());
			int arr[] = new int[n];
			String inputLine[] = br.readLine().trim().split(" ");

			//adding elements
			for(int i=0; i<n; i++){
				arr[i] = Integer.parseInt(inputLine[i]);
			}

			Kadane obj = new Kadane();

			//calling maxSubarraySum() function
			System.out.println(obj.maxSubarraySum(arr, n));
		}
	}
}


class Kadane{

	// Function to find subarray with maximum sum
	// arr: input array
	// n: size of array
	int maxSubarraySum(int arr[], int n){
		int[] dp = new int[n];

		dp[0] = arr[0];
		int max = dp[0];
		// Constructing dp here.
		for(int i=1;i<n;i++){
			dp[i] = Math.max(arr[i],dp[i-1] + arr[i]);
			if(max<dp[i]){
				max = dp[i];
			}
		}
		return max;
	}

}

