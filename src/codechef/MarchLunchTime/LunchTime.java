package codechef.MarchLunchTime;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 27/03/2021, Saturday, 21:13
 */
public class LunchTime {
	static Scanner scanner = new Scanner(System.in);

	static void solve(){
		int n = scanner.nextInt();
		int[] arr = new int[n+1];
		int[] maxHeightFromStart = new int[n+1];
		int[] maxHeightFromEnd = new int[n+1];

		for(int i=1;i<=n;i++){
			arr[i] = scanner.nextInt();
			if(maxHeightFromStart[i-1] <= arr[i]){
				maxHeightFromStart[i] = arr[i];
			}
		}

		for(int j=n-1;j>=0;j--){
			if(maxHeightFromEnd[j+1] <= arr[j]){
				maxHeightFromEnd[j+1] = arr[j];
			}
		}

		for(int i=0;i<n;i++){
//			if(arr[i] <)
			System.out.println(1);
		}

	}


	public static void main(String[] args) {
		int t = scanner.nextInt();
		while(t-- > 0){
			solve();
		}
	}
}
