package GFG;

/**
 * @author Syed Ali.
 * @createdAt 03/03/2021, Wednesday, 10:58
 */

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class MaxProfitsGfg {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
			int n = Integer.parseInt(br.readLine().trim());
			int A[] = new int[n];
			String inputLine[] = br.readLine().trim().split(" ");
			for(int i=0; i<n; i++){
				A[i] = Integer.parseInt(inputLine[i]);
			}
			MaxProfitsGfgSolution obj = new MaxProfitsGfgSolution();
			ArrayList<ArrayList<Integer> > ans = obj.stockBuySell(A, n);
			if(ans.size()==0)
				System.out.print("No Profit");
			else{
				for (int i=0; i<ans.size(); ++i){
					System.out.print("("+ans.get(i).get(0)+" "+ans.get(i).get(1)+") ");
				}
			}System.out.println();
		}
	}
}// } Driver Code Ends


//User function Template for Java

class MaxProfitsGfgSolution{
	//Function to find the days of buying and selling stock for max profit.
	ArrayList<ArrayList<Integer> > stockBuySell(int A[], int n) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		int minValue = A[0];
		int minIndex = 0;
		for(int i=1;i<n;i++){
			if(minValue > A[i]){
				minValue = A[i];
				if(i-minIndex > 1){
					ArrayList<Integer> subArray = new ArrayList<>();
					subArray.add(minIndex,i-1);
					result.add(subArray);
				}
				minIndex = i;
			}

			if(i == n-1){
				ArrayList<Integer> subArray = new ArrayList<>();
				subArray.add(minIndex);
				subArray.add(i);
				result.add(subArray);
			}
		}
		return result;
	}
}

public class MaxProfits {
}
