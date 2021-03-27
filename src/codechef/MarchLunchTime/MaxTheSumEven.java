package codechef.MarchLunchTime;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 27/03/2021, Saturday, 19:51
 */
public class MaxTheSumEven {
	static Scanner scanner = new Scanner(System.in);

	static void solve(){
		int n = scanner.nextInt();
		int sum = 0;
		int[] arr = new int[n];
		boolean checkForTwoOrThree = false;
		for(int i=0;i<n;i++){
			arr[i] = scanner.nextInt();
			if(arr[i] == 2 || arr[i] == 3){
				checkForTwoOrThree = true;
			}
			sum+= arr[i];
		}

		if(sum % 2 == 0){
			System.out.println(0);
		}else{
			Arrays.sort(arr);
			boolean solFound = false;
			int answer = 0;
			for(int i=0;i<arr.length;i++){
				if(arr[i] == 2 || arr[i] == 3){
					answer ++;
					sum -= arr[i];
					int temp = (int) Math.pow(arr[i],Math.max(0,arr[i]/2 - 1));
					sum+=temp;
					if(sum % 2 == 0){
						solFound = true;
						break;
					}
				}
			}
			if(solFound) System.out.println(answer);
			else System.out.println(-1);
		}
	}

	public static void main(String[] args) {
		int  t = scanner.nextInt();
		while(t-->0){
			solve();
		}
	}
}
