package CodeForces.RoadMap.diff1200;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 17/01/2022, Monday, 20:27
 */
public class PoisonedDagger {

	private static long bsearch(int n, long totalHp, long[] arr){
		long low = 0,high = totalHp;
		while(low <= high){
			long k = (low + high)/2;
			long currHp = k;
			for(int i = 1; i < n; i++){
				currHp += Math.min(arr[i] - arr[i - 1], k);
			}

			if(currHp >= totalHp){
				high = k - 1;
			}else{
				low = k +1;
			}
		}
		return low;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0){
			int n = s.nextInt();
			long totalHp = s.nextLong();
			long[] arr = new long[n];
			for(int i=0;i<n;i++){
				arr[i] = s.nextLong();
			}
			System.out.println(bsearch(n,totalHp,arr));

		}
	}
}
