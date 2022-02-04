package CodeForces.unsolved;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 05/01/2022, Wednesday, 12:01
 */
public class Taxi {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Integer[] arr = new Integer[n];
		for(int i=0;i<n;i++){
			arr[i] = s.nextInt();
		}

		Arrays.sort(arr, (a, b) -> {
			return b - a;
		});

		int i = 0, j = n-1,taxi = 0;

		int[] taxis = new int[n];
		while(i <= j){
			if(arr[i] <= 4 && taxis[i] == 0){
				taxi++;
				taxis[i] = 1;
			}else if(arr[i] + arr[j] <= 4){
				arr[i] +=  arr[j];
				j--;
			}else{
				i++;
			}
		}
		System.out.println(taxi);
	}
}
