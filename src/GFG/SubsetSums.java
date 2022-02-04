package GFG;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Syed Ali.
 * @createdAt 04/12/2021, Saturday, 11:57
 */
public class SubsetSums {
	// Prints sums of all subsets of array

	static Set<List<Integer>> tempSet = new HashSet<>();

	static void subsetSums(int arr[], int n) {
		List<List<Integer>> list = new ArrayList<>(tempSet);

		// There are totoal 2^n subsets
		int total = 1 << n;

		// Consider all numbers from 0 to 2^n - 1
		for (int i = 0; i < total; i++) {
			int sum = 0;

			// Consider binary representation of
			// current i to decide which elements
			// to pick.
			for (int j = 0; j < n; j++){
				int a = (1 << j);
				int b = (i & a);
				if ( b != 0)
				sum += arr[j];
			}


			// Print sum of picked elements.
			System.out.print(sum + " ");
		}
	}

	// Driver code
	public static void main(String args[]) {
		int arr[] = new int[]{5, 4, 3};
		int n = arr.length;

		subsetSums(arr, n);
	}
}
