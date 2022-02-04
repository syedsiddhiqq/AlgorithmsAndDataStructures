package LeetCode.Bsearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 10/12/2021, Friday, 17:21
 */
public class AggressiveCows {
	private static Scanner s = new Scanner(System.in);

	private static boolean isPossible(int[] barns, int d,int c,int n){
		int start = 0,cows = 1;
		for(int i=1;i<n;i++){
			if(barns[i] - barns[start] >= d){
				cows++;
				start = i;
			}
		}
		return cows >= c ;
	}

	private static int bsearch(int[] barns,int n,int cows){
		int low = 0,high = barns[n - 1];
		int max = Integer.MIN_VALUE;
		while(low <= high){
			int mid = (low + high)/2;
			if(isPossible(barns,mid,cows,n)){
				low = mid + 1;
				max = Math.max(max,mid);
			}else{
				high = mid -1;
			}
		}
		return max;
	}

	private static void solve(){
		int n = s.nextInt(),c = s.nextInt();
		int[] barns = new int[n];
		for(int i=0;i<n;i++){
			barns[i] = s.nextInt();
		}

		Arrays.sort(barns);
		System.out.println(bsearch(barns,n,c));
	}

	public static void main(String[] args) {
		int t = s.nextInt();
		while(t-- > 0){
			solve();
		}
	}
}
