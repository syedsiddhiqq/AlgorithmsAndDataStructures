package CodeForces.practice.cr636;

import java.util.*;

/**
 * @author Syed Ali.
 * @createdAt 19/03/2021, Friday, 01:10
 */
public class AlternatingSubsequence {
	static boolean checkSign(int n){
		return n>0;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		while(t-->0){
			int n = scanner.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++){
				arr[i] = scanner.nextInt();
			}

			long sum = 0;
			for(int i=0;i<n;++i){
				int j = i;
				int max = arr[i];
				while(j<n && checkSign(arr[j]) == checkSign(arr[i])){
					max = Math.max(max,arr[j]);
					j++;
				}
				i = j-1;
				sum = sum + max;
			}
			System.out.println(sum);
		}


	}
}
