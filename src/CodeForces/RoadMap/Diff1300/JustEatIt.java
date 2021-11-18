package CodeForces.RoadMap.Diff1300;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 25/06/2021, Friday, 16:56
 */
public class JustEatIt {
	private static Scanner fs = new Scanner(System.in);

	private static void solve(){
		int n = fs.nextInt();
		long[] tastes = new long[n];
		long totalTaste = 0;
		for(int i=0;i<n;i++){
			tastes[i] = fs.nextInt();
			totalTaste+= tastes[i];
		}

		long maxSum = Integer.MIN_VALUE;
		long sum = 0;
		for(int i=0;i<n-1;i++){
			sum += tastes[i];
			maxSum = Math.max(sum,maxSum);
			if(sum < 0){
				sum = 0;
			}
		}

		sum = 0;
		for(int i=1;i<n;i++){
			sum += tastes[i];
			maxSum = Math.max(sum,maxSum);
			if(sum < 0){
				sum = 0;
			}
		}

		System.out.println(totalTaste > maxSum ? "YES" : "NO");
	}

	public static void main(String[] args) {
		int t = fs.nextInt();
		while(t-->0){
			solve();
		}
	}
}
