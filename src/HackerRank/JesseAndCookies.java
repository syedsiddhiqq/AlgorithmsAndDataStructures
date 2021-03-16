package HackerRank;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 16/03/2021, Tuesday, 23:35
 */
public class JesseAndCookies {

	static void heapify(int[] arr, int i , int n){
		int largest = i;
		int left = 2 * largest + 1;
		int right =  2* largest + 2;

		if(left < n && arr[left] > arr[largest])
			largest = left;

		if(right < n && arr[right] > arr[largest])
			largest = right;

		if( largest != i){
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;

			heapify(arr,largest,n);
		}
	}

	static void heapSort(int[] arr, int n,int k){
		for(int i=n/2-1;i>=0;i--){
			heapify(arr, i,n);
		}

		while(arr[0] > k){

		}
	}
	public static void main(String[] args) {
		Scanner scanner =  new Scanner(System.in);
		int n,k;
		n = scanner.nextInt();
		k = scanner.nextInt();

		int[] arr = new int[n];

		for(int i=0;i<n;i++){
			arr[i] = scanner.nextInt();
		}


	}
}
