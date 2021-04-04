package CodeForces.RoadMap.D2_A;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 04/04/2021, Sunday, 20:22
 */
public class BsearchUVA {
	static class Fs {
		private BufferedReader reader;
		private StringTokenizer stt;

		public Fs() {
			reader = new BufferedReader(new InputStreamReader(System.in));
		}

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				return null;
			}
		}

		public String nextString() {
			while (stt == null || !stt.hasMoreTokens()) {
				stt = new StringTokenizer(nextLine());
			}
			return stt.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(nextString());
		}

		public long nextLong() {
			return Long.parseLong(nextString());
		}
	}

	static Fs fs = new Fs();

	/**
	 * @param arr
	 * @param target
	 * @param low
	 * @param high
	 * @return
	 */
	static int bsearch(int[] arr, int target, int low, int high) {
		if (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {
				return bsearch(arr, target, mid + 1, high);
			} else {
				return bsearch(arr, target, low, mid - 1);
			}
		}
		return arr[low - 1];
	}

	static int lowerBound(int arr[], int low,
						  int high, int X) {

		// Base Case
		if (low > high) {
			return low;
		}

		// Find the middle index
		int mid = low + (high - low) / 2;

		// If arr[mid] is greater than
		// or equal to X then search
		// in left subarray
		if (arr[mid] >= X) {
			return lowerBound(arr, low,
					mid - 1, X);
		}

		// If arr[mid] is less than X
		// then search in right subarray
		return lowerBound(arr, mid + 1,
				high, X);
	}

	public static void main(String[] args) {
		int n = fs.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = fs.nextInt();
		}
		int target = fs.nextInt();
		System.out.println(lowerBound(arr, 0, n, target));
		int q = fs.nextInt();
	}
}
