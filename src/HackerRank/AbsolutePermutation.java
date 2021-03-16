package HackerRank;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 21/02/2021, Sunday, 19:55
 * https://www.hackerrank.com/challenges/absolute-permutation/problem
 */
public class AbsolutePermutation {
	static Scanner scanner = new Scanner(System.in);

	public static void solve(){
		int n = scanner.nextInt();
		int k = scanner.nextInt();

		// 3 possibility is there.
		// if k == 0 print n numbers.
		if(k == 0){
			for(int i=1;i<=n;i++)
				System.out.print(i+" ");

			System.out.print("\n");
		}else if(n % 2 *k != 0){

			// Permutation is not possible
			System.out.print(-1);
			System.out.print("\n");
		}else {
			// print i+k - k times and i-k - k times
			Boolean add = true;
			for(int i=1;i<=n;i++){
				if(add){
					System.out.print(i+k + " ");
				}else{
					System.out.print(i-k + " ");
				}

				if(i % k == 0){
					if(add) add = false;
					else add = true;
				}
			}
			System.out.print("\n");
		}
	}
	public static void main(String[] args) {
		int testCases =  scanner.nextInt();
		while(testCases-->0){
			solve();
		}
	}
}
