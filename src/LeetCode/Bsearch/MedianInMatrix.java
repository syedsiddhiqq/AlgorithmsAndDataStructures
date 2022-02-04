package LeetCode.Bsearch;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Syed Ali.
 * @createdAt 07/12/2021, Tuesday, 13:52
 */
public class MedianInMatrix {
	private static int countSmallerThanMid(ArrayList<Integer> row, int mid) {
		int l = 0, h = row.size() - 1;
		while(l <= h) {
			int md = (l + h) >> 1;
			if(row.get(md) <= mid) {
				l = md + 1;
			}
			else {
				h = md - 1;
			}
		}
		return l;
	}

	public static int findMedian(ArrayList<ArrayList<Integer>> A) {
		int low = Integer.MIN_VALUE;
		int high = Integer.MAX_VALUE;
		int n = A.size();
		int m = A.get(0).size();
		while(low <= high) {
			int mid = (low + high) >> 1;
			int cnt = 0;
			for(int i = 0;i<n;i++) {
				cnt += countSmallerThanMid(A.get(i), mid);
			}

			if(cnt <= (n * m) / 2) low = mid + 1;
			else high = mid - 1;
		}
		return low;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> input = new ArrayList<>();

		input.add(new ArrayList<>(Arrays.asList(1, 3, 5)));
		input.add(new ArrayList<>(Arrays.asList(2, 6, 9)));
		input.add(new ArrayList<>(Arrays.asList(3, 6, 9)));

		System.out.println(findMedian(input));
	}
}
