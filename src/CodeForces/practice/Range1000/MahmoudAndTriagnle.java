//package CodeForces.practice.Range1000;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 21/03/2021, Sunday, 03:37
 * https://codeforces.com/problemset/problem/766/B
 */
public class MahmoudAndTriagnle {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = scanner.nextInt();
		}

		Arrays.sort(arr);

		boolean flag = false;
		for(int i=1;i<n-1;i++){
			if((arr[i]+arr[i-1]) > arr[i+1]){
				flag = true;
				break;
			}
		}

		System.out.println(flag?"YES":"NO");
	}
}
