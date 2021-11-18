package CodeForces.RoadMap.Diff1300;

import java.util.Scanner;

/**
 *
 * @author Syed Ali.
 * @createdAt 18/11/2021, Thursday, 12:27
 */
public class CoGrowingSequence {

	private static Scanner sc = new Scanner(System.in);

	private static int[] readArr(int n){
	    int[] arr = new int[n];
	    for(int i=0;i<n;i++){
	        arr[i] = sc.nextInt();
	    }
	    return arr;
	}

	private static void solve(){
		int n = sc.nextInt();
		int[] arr = readArr(n);

		int[] output = new int[n];

		for(int i=1;i<n;i++){
			int prev = arr[i - 1] ^ output[i - 1];
			int now = arr[i];
			output[i] = prev & ~now;
		}

		for(int i=0;i<n;i++){
			System.out.print(output[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int t = sc.nextInt();
		while(t-->0){
			solve();
		}
	}
}
