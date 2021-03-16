package GFG;

import java.util.*;
import java.io.*;
import java.lang.*;

/**
 * @author Syed Ali.
 * @createdAt 28/02/2021, Sunday, 03:03
 */
public class MaxPlatforms {
}

// { Driver Code Starts
//Initial Template for Java


class Driver_class
{
	public static void main(String args[])throws IOException
	{
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());

		while(t-- > 0)
		{
			String str[] = read.readLine().trim().split(" ");
			int n = Integer.parseInt(str[0]);

			int arr[] = new int[n];
			int dep[] = new int[n];

			str = read.readLine().trim().split(" ");
			for(int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(str[i]);
			str = read.readLine().trim().split(" ");
			for(int i = 0; i < n; i++)
				dep[i] = Integer.parseInt(str[i]);

			System.out.println(new Platform().findPlatform(arr, dep, n));
		}
	}


}


// } Driver Code Ends


//User function Template for Java

class Platform
{
	static int findPlatform(int arr[], int dep[], int n){
		Arrays.sort(arr);
		Arrays.sort(dep);

		int maxPlatforms = 1,neededPlatforms = 1,arrivalPointer = 1,deptPointer = 0;
		while(arrivalPointer < n && deptPointer < n){
			if(arr[arrivalPointer] > dep[deptPointer]){
				deptPointer++;
				maxPlatforms--;
			}else if(arr[arrivalPointer] < dep[deptPointer]){
				arrivalPointer++;
				maxPlatforms++;
				neededPlatforms = Math.max(maxPlatforms,neededPlatforms);
			}
		}
		return neededPlatforms;
	}

}

