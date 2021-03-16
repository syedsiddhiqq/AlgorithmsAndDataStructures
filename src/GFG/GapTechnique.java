package GFG;

/**
 * @author Syed Ali.
 * @createdAt 22/02/2021, Monday, 03:04
 */
// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.io.*;

public class GapTechnique
{
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
			String inputLine[] = br.readLine().trim().split(" ");
			int n = Integer.parseInt(inputLine[0]);
			int m = Integer.parseInt(inputLine[1]);
			int arr1[] = new int[n];
			int arr2[] = new int[m];
			inputLine = br.readLine().trim().split(" ");
			for(int i=0; i<n; i++){
				arr1[i] = Integer.parseInt(inputLine[i]);
			}
			inputLine = br.readLine().trim().split(" ");
			for(int i=0; i<m; i++){
				arr2[i] = Integer.parseInt(inputLine[i]);
			}
			Solution1 ob = new Solution1();
			ob.merge(arr1, arr2, n, m);

			StringBuffer str = new StringBuffer();
			for(int i=0; i<n; i++){
				str.append(arr1[i]+" ");
			}
			for(int i=0; i<m; i++){
				str.append(arr2[i]+" ");
			}
			System.out.println(str);
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution1
{

	public static int nextGap(int gapValue){
		return gapValue % 2 == 0 ? gapValue/2 : gapValue/2 + 1;
	}


	public static void merge(int arr1[], int arr2[], int n, int m) {
		int gap = nextGap(n+m) - 1;
		int start = 0;
		int start2;
		start2 = gap - n;
		while(gap > 0){

			// perform operation in 1st array.
			if(start < n && start+gap < n){
				if(arr1[start]>arr2[start2]){
					int temp = arr1[start];
					arr1[start] = arr2[start2];
					arr2[start2] = temp;
				}
			}

			// Perform if start and gap lies in both arrays.
			if(start < n && start + gap >=n && start2 < m){
				if(arr1[start]>arr2[start2]){
					int temp = arr1[start];
					arr1[start] = arr2[start2];
					arr2[start2] = temp;
				}
			}

			// Perform if completely lies in second
			if(start > n && start + gap > n && start2 <m){
				if(arr1[start]>arr2[start2]){
					int temp = arr1[start];
					arr1[start] = arr2[start2];
					arr2[start2] = temp;
				}
			}

			if(start > m || start2 > m){
				start = 0;
				gap = nextGap(gap+1) - 1;
				start2 = gap - n;
			}else{
				start += gap;
				start2 += gap;
			}
		}
	}
}
