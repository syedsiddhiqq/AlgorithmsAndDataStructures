//package CodeForces.practice.Range800;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 21/03/2021, Sunday, 00:07
 * https://codeforces.com/problemset/problem/1501/B
 */
public class NapoleanCake {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		while(t-->0){
			int n = scanner.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++){
				arr[i] = scanner.nextInt();
			}
			int[] result = new int[n];
			int max = arr[n-1];
			for(int i=n-1;i>=0;i--){
				max = Math.max(max,arr[i]);
				if(max > 0){
					result[i] = 1;
					max--;
				}
			}

			for(int i=0;i<n;i++) System.out.print(result[i] + " ");
			System.out.println();
		}
	}
}
