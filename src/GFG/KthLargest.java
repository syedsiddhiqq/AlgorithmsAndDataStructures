package GFG;

import java.io.*;
import java.util.*;

/**
 * @author Syed Ali.
 * @createdAt 02/03/2021, Tuesday, 14:01
 */
public class KthLargest {
}

// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

class KthLargestSubClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();

			int arr[] = new int[n];

			for (int i = 0; i < n; i++)
				arr[i] = sc.nextInt();

			int k = sc.nextInt();

			System.out.println(kthSmallest(arr, 0, n - 1, k));
		}
	}

	// } Driver Code Ends
	//User function Template for Java

	static void heapify(int arr[],int n,int i){
		int smallest = i;
		int left = i*2;
		int right = (2*i)+1;

		if(left<n && arr[left] < arr[smallest])
			smallest = left;

		if(right < n && arr[right] < arr[smallest])
			smallest = right;

		if(smallest != i){
			int temp = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = temp;

			heapify(arr,n,smallest);
		}
	}
	public static int kthSmallest(int[] arr, int l, int r, int k) {
		for(int i=(r+1)/2;i>=0;i--){
			heapify(arr,r+1,i);
		}


		int count = 1;
		for(int i=r;i>0;i--){
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			if(count == k){
				return arr[i];
			}

			heapify(arr,i,0);
			count++;
		}
		return arr[0];
	}

}
