package CodeForces.practice.Range1200to1400;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 21/12/2021, Tuesday, 13:51
 */
public class SwapElements {

	private static Scanner s = new Scanner(System.in);

	private static void swap(int[] arr,int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void solve(){
		int n = s.nextInt();
		int[] arr = new int[n];

		for(int i=0;i<n;i++)
			arr[i] = s.nextInt();

		if(n == 1){
			System.out.println("0");
		}else{
			int elementToSwap = -1,operations = 0;
			for(int i=1;i<n;i++){
				if(arr[i] == arr[i-1]){
					if(elementToSwap == -1){
						for(int j=i+1;j<n;j++){
							if(arr[j] != arr[i]){
								elementToSwap = j;
								break;
							}
						}
						swap(arr,i,elementToSwap);
						operations += elementToSwap - i;
						elementToSwap++;
					}else if(elementToSwap < n){
						swap(arr,i,elementToSwap);
						operations += elementToSwap - i;
						elementToSwap++;
					}else{
						System.out.println("-1");
						return;
					}
				}
			}
			System.out.println(operations);
		}
	}

	public static void main(String[] args) {
		int t = s.nextInt();
		while(t-->0){
			solve();
		}
	}
}
