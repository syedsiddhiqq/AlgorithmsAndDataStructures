//package GFG;
//
///**
// * @author Syed Ali.
// * @createdAt 03/03/2021, Wednesday, 01:15
// */
//
//// { Driver Code Starts
////Initial Template for Java
//
//
//
//import java.io.*;
//import java.util.*;
//
//class PythogoreanTripletMain {
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int tc = Integer.parseInt(br.readLine());
//		while (tc-- > 0) {
//			int n = Integer.parseInt(br.readLine());
//			int[] arr = new int[n];
//			String[] inputLine = br.readLine().split(" ");
//			for (int i = 0; i < n; i++) {
//				arr[i] = Integer.parseInt(inputLine[i]);
//			}
//
//			boolean ans = new Solution().checkTriplet(arr, n);
//			System.out.println(ans ? "Yes" : "No");
//		}
//	}
//}// } Driver Code Ends
//
//
////User function Template for Java
//
//
//
//class Solution {
//	boolean checkTriplet(int[] arr, int n) {
//		int[] frequency = new int[10000000];
//		for(int i=0;i<n;i++){
//			arr[i] = arr[i] * arr[i];
//			frequency[arr[i]] = 1;
//		}
//
//		for(int i=0;i<n;i++){
//			for(int j=i+1;j<n;j++){
//				if(frequency[arr[i]+arr[j]] == 1){
//					return true;
//				}
//			}
//		}
//		return false;
//	}
//
//}
//public class PythogoreanTriplet {
//}
