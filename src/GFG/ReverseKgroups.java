package GFG;


import java.io.*;
import java.util.*;

/**
 * @author Syed Ali.
 * @createdAt 28/02/2021, Sunday, 22:27
 */
public class ReverseKgroups {
}

// { Driver Code Starts
//Initial Template for Java


 class GFG3 {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases

		//while testcases exist
		while(t-->0){

			String inputLine1[] = br.readLine().trim().split(" ");
			int n = Integer.parseInt(inputLine1[0]);
			int k = Integer.parseInt(inputLine1[1]);

			ArrayList<Integer> arr = new ArrayList<>();
			String inputLine2[] = br.readLine().trim().split(" ");
			for(int i=0; i<n; i++){
				arr.add(Integer.parseInt(inputLine2[i]));
			}

			Solution2 obj = new Solution2();
			obj.reverseInGroups(arr, n, k);

			StringBuffer str = new StringBuffer();
			for(int i=0; i<n; i++){
				str.append(arr.get(i) + " ");
			}
			System.out.println(str);
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution2 {
	//Function to reverse every sub-array group of size k.
	void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
		for(int i=0;i<n;i+=k){
			int start = i;
			int end = Math.min(i+k-1,n-1);

			while(start<=end){
				int temp = arr.get(start);
				arr.add(start,arr.get(end));
				arr.add(end,temp);
				start++;
				end--;
			}
		}
	}
}

