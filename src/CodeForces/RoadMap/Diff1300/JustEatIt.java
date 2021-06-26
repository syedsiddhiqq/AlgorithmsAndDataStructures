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
		int[] tastes = new int[n];
		int totalTaste = 0;
		for(int i=0;i<n;i++){
			tastes[i] = fs.nextInt();
			totalTaste+= tastes[i];
		}

		int max = Integer.MIN_VALUE;
		int count = 0;
		for(int i=0;i<n;i++){
			count += 1;
			int sum = tastes[i];
			if(count != n){
				max = Math.max(max,sum);
			}
			for(int j=i+1;j<n && sum > 0;j++){
				count += 1;
				sum += tastes[j];
				if(count != n){
					max = Math.max(max,sum);
				}
			}
			count = 0;
		}
		System.out.println(totalTaste > max ? "YES" : "NO");
	}

	public static void main(String[] args) {
		int t = fs.nextInt();
		while(t-->0){
			solve();
		}
	}
}
