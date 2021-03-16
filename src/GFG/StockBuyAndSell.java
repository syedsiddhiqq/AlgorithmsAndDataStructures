package GFG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author Syed Ali.
 * @createdAt 06/03/2021, Saturday, 11:31
 */
public class StockBuyAndSell {
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
			StockBuyAndCellImpl obj = new StockBuyAndCellImpl();
			ArrayList<ArrayList<Integer>> ans = obj.stockBuySell(A, n);
			if(ans.size()==0)
				System.out.print("No Profit");
			else{
				for (int i=0; i<ans.size(); ++i){
					System.out.print("("+ans.get(i).get(0)+" "+ans.get(i).get(1)+") ");
				}
			}System.out.println();
		}
	}


}
class StockBuyAndCellImpl{
	ArrayList<ArrayList<Integer> > stockBuySell(int A[], int n) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		int aPointer = 0;
		int bPointer = aPointer+1;
		while(aPointer < n-1 && bPointer<n-1){

			// Find local minima.
			while(aPointer+1 < n){
				if(A[aPointer] < A[aPointer+1]){
					break;
				}else{
					aPointer++;
				}
			}
			// Now index of aPointer will be our local minima.

			// Now find local maxima
			bPointer = aPointer+1;
			while(true){
				if(A[bPointer] > A[bPointer+1]){
					// we found our local maxima..
					//push index of local minima and maxima
					ArrayList<Integer> subResult = new ArrayList<>();
					subResult.add(aPointer);
					subResult.add(bPointer);
					result.add(subResult);
					aPointer = bPointer+1;
					break;
				}else{
					bPointer++;

					if(bPointer == n-1){
						ArrayList<Integer> subResult = new ArrayList<>();
						subResult.add(aPointer);
						subResult.add(bPointer);
						result.add(subResult);
						break;
					}
				}
			}
		}
		return result;
	}
}