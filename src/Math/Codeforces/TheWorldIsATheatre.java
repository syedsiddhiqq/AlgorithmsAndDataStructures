//package Math.Codeforces;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 30/03/2021, Tuesday, 19:56
 */
public class TheWorldIsATheatre {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int t = sc.nextInt();
		long ans = 0;
		for(int i = 4 ; i < t ; i++){
			ans += binomial(n,i) * binomial(m,t-i);
		}
		System.out.println(ans);
	}
	static long binomial(int n, int k){
		long result = 1;
		for ( int i = 0; i < k; i ++){
			result *= (n-i);
			result /= (i+1);
		}
		return result ;
	}
}
