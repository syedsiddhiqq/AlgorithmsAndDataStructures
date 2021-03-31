//package Math.Codeforces;

import java.util.Scanner;
/**
 * @author Syed Ali.
 * @createdAt 01/04/2021, Thursday, 03:05
 */
public class KthNotDivisibleByN {
	static Scanner scanner = new Scanner(System.in);

	static long MAX = (long)Math.pow(10,9);

	static void solve(){
		int n,k;
		n = scanner.nextInt();
		k = scanner.nextInt();

		long low = 0;
		long high = Integer.MAX_VALUE;
		long answer=0;
		while(low<=high){
			long mid = (low+high)/2;
			long sol = (mid - mid/n);
			if(k == sol){
				answer = mid;
				high = mid - 1;
			}else if(k < sol){
				high = mid-1;
			}else{
				low = mid+1;
			}
		}
		System.out.println(answer);
	}

	public static void main(String[] args) {
		int t = scanner.nextInt();
		while(t-->0){
			solve();
		}
	}
}
