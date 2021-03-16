package GFG;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Syed Ali.
 * @createdAt 06/03/2021, Saturday, 15:02
 */
public class ZigZagArrayTransform {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		while (tc-- > 0) {
			String[] inputLine;
			int n = Integer.parseInt(br.readLine().trim());
			int[] arr = new int[n];
			inputLine = br.readLine().trim().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(inputLine[i]);
			}

			new ZigZagSolution().zigZag(arr, n);
			for (int i = 0; i < n; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}
}

class ZigZagSolution {
	private void swap(int[] arr, int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	void zigZag(int arr[], int n) {

		// if to check less that setting as true.. else greater than
		boolean flag = true;

		for(int i=0;i<n-1;i++){
			if(flag){
				flag = false;
				if(arr[i] > arr[i+1]){
					swap(arr,i,i+1);
				}
			}else{
				flag = true;
				if(arr[i] < arr[i+1]){
					swap(arr,i,i+1);
				}
			}
		}
	}

	public int lastIndex( String s) {
		for(int i=s.length()-1;i>=0;i++){
			if(s.charAt(i) == '1'){
				return i;
			}
		}
		return -1;
	}
}
