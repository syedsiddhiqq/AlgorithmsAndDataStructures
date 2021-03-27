package codechef.MarchLunchTime;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 27/03/2021, Saturday, 19:35
 */
public class Motivation {

	static Scanner scanner = new Scanner(System.in);

	static void solve(){
		int n = scanner.nextInt();
		int k = scanner.nextInt();

		int max = Integer.MIN_VALUE;
		int x,y;
		for(int i=0;i<n;i++){
			x = scanner.nextInt();
			y = scanner.nextInt();

			if(x <= k ){
				max = Math.max(max,y);
			}
		}
		System.out.println(max);
	}

	public static void main(String[] args) {

		int t = scanner.nextInt();
		while(t-->0){
			solve();
		}
	}
}
