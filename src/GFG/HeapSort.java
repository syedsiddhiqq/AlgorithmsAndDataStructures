package GFG;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 01/03/2021, Monday, 18:43
 */
public class HeapSort {
	static Scanner scanner = new Scanner(System.in);

	static void heapify(int arr[],int n,int i){
		int largest = i;
		int left = 2*i+1,right = 2*i+2;
		if(left<n && arr[left] > arr[largest])
			largest = left;

		if(right<n && arr[right] > arr[largest])
			largest = right;

		if(largest!=i){
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;

			heapify(arr,n,largest);
		}
	}

	static void heapSort(int arr[],int n){
		for(int i=n/2-1;i>=0;i--){
			heapify(arr,n,i);
		}

		// to perform deletion operation.

		for(int i=n-1;i>=0;i--){
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			heapify(arr,i,0);
		}
	}

	public static void main(String[] args) {
		int n;
		n = scanner.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = scanner.nextInt();
		}

		heapSort(arr,n);

		for(int i=0;i<n;i++)
			System.out.println(arr[i]);
	}
}
