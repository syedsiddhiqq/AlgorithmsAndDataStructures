package GFG;

/**
 * @author Syed Ali.
 * @createdAt 03/03/2021, Wednesday, 00:34
 */
// { Driver Code Starts
import java.io.*;
import java.lang.*;


class TrappingWaterSolutionArray {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){

			//size of array
			int n = Integer.parseInt(br.readLine().trim());
			int arr[] = new int[n];
			String inputLine[] = br.readLine().trim().split(" ");

			//adding elements to the array
			for(int i=0; i<n; i++){
				arr[i] = Integer.parseInt(inputLine[i]);
			}

			TrappingWaterSolution obj = new TrappingWaterSolution();

			//calling trappingWater() function
			System.out.println(obj.trappingWater(arr, n));
		}
	}
}

// } Driver Code Ends




class TrappingWaterSolution {

	static int trappingWater(int arr[], int n) {
		int total = 0;
		int[] left  = new int[n];
		int[] right = new int[n];
		left[0] = arr[0];
		right[n-1] = arr[n-1];

		// Precomputing max from left and max from right
		for(int i=1,j=n-2; i<n && j>=0 ;i++,j--){
			left[i] = Math.max(left[i-1],arr[i]);
			right[j] = Math.max(right[j+1],arr[j]);
		}


		for(int i=1;i<n-1;i++){
			int minValue = Math.min(left[i],right[i]);
			total+=minValue - arr[i];
		}
		return total;
	}
}




public class TrappingWater {
}


