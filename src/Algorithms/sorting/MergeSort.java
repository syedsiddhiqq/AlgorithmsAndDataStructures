package Algorithms.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Syed Ali.
 * @createdAt 22/04/2021, Thursday, 15:26
 */
public class MergeSort {

	static void merge(int[] arr, int start, int mid, int end) {
		int[] n1 = new int[mid - start + 1];
		int[] n2 = new int[end - mid];

		int index = 0;
		for (int i = start; i <= mid; i++) {
			n1[index++] = arr[i];
		}

		index = 0;
		for (int i = mid + 1; i <= end; i++) {
			n2[index++] = arr[i];
		}

		int aPointer = 0;
		int bPointer = 0;
		int k = start;
		while (aPointer < n1.length && bPointer < n2.length) {
			if (n1[aPointer] <= n2[bPointer]) {
				arr[k] = n1[aPointer];
				++aPointer;
			} else {
				arr[k] = n2[bPointer];
				++bPointer;
			}
			++k;
		}

		while (bPointer < n2.length) {
			arr[k] = n2[bPointer];
			bPointer++;
			k++;
		}

		while (aPointer < n1.length) {
			arr[k] = n1[aPointer];
			aPointer++;
			k++;
		}
	}

	static void sort(int[] arr, int start, int end) {
		if (start == end) {
			return;
		}
		int mid = (start + end) / 2;
		sort(arr, start, mid);
		sort(arr, mid + 1, end);

		merge(arr, start, mid, end);
	}

	public static void main(String[] args) {
		Stack stack = new Stack();
		List<Integer> a = new ArrayList<>();
		Stack<Integer> stackA = new Stack<>();
		int arr[] = { 12, 11, 13, 5, 6, 7 };
		sort(arr,0,arr.length-1);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
}
