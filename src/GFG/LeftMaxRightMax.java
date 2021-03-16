package GFG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Syed Ali.
 * @createdAt 06/03/2021, Saturday, 12:35
 */
public class LeftMaxRightMax {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
		while(t-- > 0)
		{
			int n = Integer.parseInt(br.readLine().trim());
			int a[] = new int[(int)(n)];
			String inputLine[] = br.readLine().trim().split(" ");
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(inputLine[i]);
			}

			LeftMaxRightMaxSolution obj = new LeftMaxRightMaxSolution();
			System.out.println(obj.findElement(a, n));

		}
	}
}

class LeftMaxRightMaxSolution{
	public int findElement(int arr[], int n){
		int[] leftMax = new int[n];
		int[] rightMax = new int[n];

		leftMax[0] = arr[0];
		rightMax[n-1] = arr[n-1];
		for(int i=1,j=n-2;i<n && j>=0;i++,j--){
			if(arr[i] > leftMax[i-1]){
				leftMax[i] = arr[i];
			}else{
				leftMax[i] = leftMax[i-1];
			}
			if(arr[j] < rightMax[j+1]){
				rightMax[j] = arr[j];
			}else{
				rightMax[j] = rightMax[j+1];
			}
		}


		for(int i=1;i<n-1;i++){
			if(arr[i] >= leftMax[i-1] && arr[i] <= rightMax[i+1]) {
				return arr[i];
			}
		}
		return -1;
	}
}
