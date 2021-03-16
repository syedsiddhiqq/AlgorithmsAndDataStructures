package Algorithms;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 16/03/2021, Tuesday, 15:29
 * https://www.youtube.com/watch?v=Q_eia3jC9Ts
 */
public class HeapSort {

	public static void heapify(int[] arr, int i, int n){
		int largest = i;
		int leftChild = 2 * i + 1;
		int rightChild = 2 * i + 2;

		if(leftChild < n && arr[leftChild] > arr[largest]){
			largest = leftChild;
		}

		if(rightChild < n && arr[rightChild] > arr[largest]){
			largest = rightChild;
		}

		if(largest != i){
			int temp = arr[largest];
			arr[largest] = arr[i];
			arr[i] = temp;

			heapify(arr, largest,n);
		}
	}

	public static void heapSort(int[] arr, int n){
		// Construction of heap
		// Ignoring leaf nodes as it is already complete bst.
		for(int i=n/2-1;i>=0;i--){
			heapify(arr,i,n);
		}

		// perform delete operation..
		for(int i=n-1;i>=0;i--){
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			heapify(arr,0,i);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = scanner.nextInt();
		}

	}
}
