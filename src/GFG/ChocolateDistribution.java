package GFG;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 03/03/2021, Wednesday, 02:20
 */
public class ChocolateDistribution {
	static Scanner scanner = new Scanner(System.in);

	static void merge(int[] arr, int start, int mid, int end){
		int aPointer = start,bPointer = mid+1;

		int[] newArray = new int[arr.length];
		int newArrayIterator = 0;
		while(aPointer <= mid && bPointer <= end){
			if(arr[aPointer] >= arr[bPointer]){
				newArray[newArrayIterator++] = arr[bPointer];
				bPointer++;
			}else {
				newArray[newArrayIterator++] = arr[aPointer];
				aPointer++;
			}
		}

		for(int i=aPointer;i<=mid;i++){
			newArray[newArrayIterator++] = arr[i];
		}

		for(int i=bPointer;i<=end;i++){
			newArray[newArrayIterator++] = arr[i];
		}

		for(int i=start,j = 0;i<=end && j < newArrayIterator;i++,j++){
			arr[i] = newArray[j];
		}
	}

	static void mergeSort(int[] arr, int start, int end){
		if(start >= end){
			return;
		}
		int mid = (start+end)/2;
		mergeSort(arr,start,mid);
		mergeSort(arr,mid+1,end);
		merge(arr,start,mid,end);
	}

	static int solve(){
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) arr[i] = scanner.nextInt();
		int numberOfChildren = scanner.nextInt();
		mergeSort(arr,0,n-1);
		Arrays.sort(arr);
		int minValue = Integer.MAX_VALUE;
		for(int i=0;i<n && (i+numberOfChildren)-1 < n;i++){
			int value = Math.abs(arr[(i+numberOfChildren) - 1] - arr[i]);
			if(minValue > value){
				minValue = value;
			}
		}
		return minValue;
	}
	public static void main(String[] args) {

		int testCases = scanner.nextInt();

		while(testCases-->0){
			System.out.println(solve());
		}
	}
}
