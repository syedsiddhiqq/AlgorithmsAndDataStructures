package GFG;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 24/02/2021, Wednesday, 01:01
 */
public class MergeSort {
	static Scanner scanner = new Scanner(System.in);

	private static void merge(int arr[],int start, int mid, int end){
		int aPointer = start,bPointer = mid+1;
		int[] newArray = new int[arr.length];
		int newArraySize = 0;
		while(aPointer <= mid &&  bPointer <= end){

			if(arr[aPointer] > arr[bPointer]){
				newArray[newArraySize++] = arr[bPointer];
				bPointer++;
			}else{
				newArray[newArraySize++] = arr[aPointer];
				aPointer++;
			}
		}

		while(aPointer<=mid){
			newArray[newArraySize++] = arr[aPointer++];
		}

		while(bPointer<=end){
			newArray[newArraySize++] = arr[bPointer++];
		}

		for(int i = start,j = 0;i<=end && j < newArraySize;i++,j++){
			arr[i] = newArray[j];
		}
	}

	private static void mergeSort(int arr[],int start, int end){
		if(start>=end){
			return;
		}
		int mid = (start+end)/2;
		mergeSort(arr,start,mid);
		mergeSort(arr,mid+1,end);
		merge(arr,start,mid,end);
	}

	public static void main(String[] args) {
		int n;
		n = scanner.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = scanner.nextInt();
		}
		mergeSort(arr,0,n-1);
		for(int i=0;i<n;i++)
			System.out.println(arr[i]);
	}
}
