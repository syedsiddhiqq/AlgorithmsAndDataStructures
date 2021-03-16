package Algorithms;

import java.util.Arrays;

/**
 * @author Syed Ali.
 * @created 14/12/2020, Monday, 11:11
 */
public class QuickSortImpl {

	public static class QuickSort {

		public QuickSort() {
		}

		public int partition(int[] arr, int low, int high) {
			// Taking pivot as the last element of array...
			int pivot = arr[high];
			int partitionIndex = low;
			int temp;

			for (int i = low; i < high; i++) {
				if (arr[i] <= pivot) {
					temp = arr[i];
					arr[i] = arr[partitionIndex];
					arr[partitionIndex] = temp;
					partitionIndex++;
				}
			}
			temp = arr[partitionIndex];
			arr[partitionIndex] = arr[high];
			arr[high] = temp;
			return partitionIndex;
		}

		public void printElements(int[] arr) {
			Arrays.stream(arr).forEach(System.out::println);
		}

		public void qsort(int[] arr, int low, int high) {
			if (low < high) {
				int partitionIndex = partition(arr, low, high);
				qsort(arr, low, partitionIndex-1);
				qsort(arr, partitionIndex + 1, high);
			}
		}

		public void performQuickSort(int[] arr) {
//			int n;
//			Scanner scanner = new Scanner(System.in);
//			n = scanner.nextInt();
//			int arr[] = new int[n];
//			for (int i = 0; i < n; i++) {
//				arr[i] = scanner.nextInt();
//			}
			qsort(arr, 0, arr.length - 1);
			printElements(arr);
		}
	}

	public static void main(String[] args) {
		QuickSort quickSort = new QuickSort();
		int[] arr = {10,22,11,45,6,9};
		quickSort.performQuickSort(arr);
	}
}
