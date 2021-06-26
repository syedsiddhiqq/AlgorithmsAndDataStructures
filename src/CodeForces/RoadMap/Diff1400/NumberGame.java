package CodeForces.RoadMap.Diff1400;

import java.util.*;

/**
 * @author Syed Ali.
 * @createdAt 10/05/2021, Monday, 18:12
 */
public class NumberGame {
	private static Scanner s = new Scanner(System.in);

	private static boolean isPrime(int n){
		for(int i = 2; i < Math.min(50000,n); i++)
			if(n % i == 0)
				return false;
		return true;
	}

	private static void solve() {
		String ash = "Ashishgup";
		String ff = "FastestFinger";
		int n = s.nextInt();

		if(n == 1){
			System.out.println(ff);
		}else if(n == 2){
			System.out.println(ash);
		}else if(n % 2 != 0){
			System.out.println(ash);
		}else {
			// if n is only power of 2.
			if((n & (n - 1)) == 0){
				System.out.println(ff);
			}else if(n % 4 == 0){
				System.out.println(ash);
			}else if(isPrime(n/2)){
				System.out.println(ff);
			}else{
				System.out.println(ash);
			}
		}
	}

	public static void main(String[] args) {
		int t = s.nextInt();
		while (t-- > 0) {
			solve();
		}
	}
}
