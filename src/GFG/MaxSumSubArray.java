package GFG;// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class MaxSumSubArray{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int s = sc.nextInt();

			int[] m = new int[n];
			for (int j = 0; j < n; j++) {
				m[j] = sc.nextInt();
			}

			Subarray obj = new Subarray();
			ArrayList<Integer> res = obj.subarraySum(m, n, s);
			for(int ii = 0;ii<res.size();ii++)
				System.out.print(res.get(ii) + " ");
			System.out.println();
		}
	}

}// } Driver Code Ends



class Subarray{
	static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
		// Using sliding window technique..
		int sum = 0;
		for(int i=0;i<n;i++){
			sum = arr[i];
			for(int j=i+1;j<n && sum < s;j++){
				sum += arr[j];
				if(sum == s){
					ArrayList<Integer> finalArray = new ArrayList<>();
					for(int k = i;k<j;k++){
						finalArray.add(arr[k]);
					}
					return finalArray;
				}
			}
		}
		return null;
	}
}