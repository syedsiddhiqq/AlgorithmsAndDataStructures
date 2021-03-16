package Algorithms;

/**
 * @author Syed Ali.
 * @created 14/12/2020, Monday, 11:51
 */
public class BinarySearchImpl {
	public static class BinarySearch {
		public BinarySearch() {
		}

		int bsearch(int[] arr, int start, int end, int elementToFind) {
			int midpoint = (start + end) / 2;
			if (arr[midpoint] == elementToFind) return midpoint;
			else if (elementToFind < arr[midpoint]) {
				return bsearch(arr, start, midpoint - 1, elementToFind);
			} else {
				return bsearch(arr, midpoint + 1, end, elementToFind);
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = {10, 13, 43, 54, 12, 43};
		BinarySearch binarySearch = new BinarySearch();
		QuickSortImpl.QuickSort quickSort = new QuickSortImpl.QuickSort();
		quickSort.performQuickSort(arr);
		System.out.println(binarySearch.bsearch(arr, 0, arr.length - 1, 43));
	}
}
