package GFG;

/**
 * @author Syed Ali.
 * @createdAt 22/02/2021, Monday, 23:46
 */
// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int g = 0;g < t;g++)
		{
			String[] str = (br.readLine()).trim().split(" ");
			int n = Integer.parseInt(str[0]);
			int m = Integer.parseInt(str[1]);

			int[] x = new int[n];
			str = (br.readLine()).trim().split(" ");
			for(int i = 0;i< n;i++)
				x[i] = Integer.parseInt(str[i]);

			str = (br.readLine()).trim().split(" ");
			int[] y = new int[m];
			for(int i = 0;i< m;i++)
			{
				y[i] = Integer.parseInt(str[i]);

			}
			System.out.println(new Num_of_pair().countPairs(x, y, n, m));

		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Num_of_pair
{

	static int binarySearch(int y[],int target,int m){
		int mid;
		int start = 0, end = m-1;
		while(true){
			mid= (start + end)/2;
			if(start == end && start >= m-1){
				return -1;
			}if(y[mid] == target || start == end){
				return mid + 1;
			}else if(target < y[mid]){
				end = mid - 1;
			}else{
				start = mid + 1;
			}
		}
	}
	// Function to count number of pairs of x, y
	// x[], y[]: input array elements
	// n, m: size of arrays x[] and y[] respectively
	static long countPairs(int x[], int y[], int n, int m){
		int countNumbers = 0;
		Arrays.sort(y);
		for(int i = 0;i<n;i++){
			int result = binarySearch(y,x[i],m);
			if(result != -1 ){
				countNumbers += m - result;
			}
		}
		return countNumbers;
	}
}
