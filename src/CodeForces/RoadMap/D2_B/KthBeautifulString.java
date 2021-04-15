//package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 15/04/2021, Thursday, 19:18
 */
public class KthBeautifulString {
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

	static int lowerBound(int arr[], int low,
						  int high, int X) {
		if (low > high) {
			return low;
		}
		int mid = low + (high - low) / 2;
		if (arr[mid] >= X) {
			return lowerBound(arr, low,
					mid - 1, X);
		}
		return lowerBound(arr, mid + 1,
				high, X);
	}


	static void solve() {
		int n, k;
		n = fs.nextInt();
		k = fs.nextInt();
		int[] arr = new int[n];
		for (int i = 1; i < n; i++) {
			arr[i] = (i * (i + 1)) / 2;
		}
		int range = lowerBound(arr, 0, n - 1, k);
		StringBuilder initialStr = new StringBuilder();
		for (int i = 0; i < n; i++) {
			initialStr.append("a");
		}

		int r = arr[range]-k+1;
		initialStr.setCharAt(n-2-range, 'b');
		initialStr.setCharAt(n - 2 - range + r, 'b');

		System.out.println(initialStr);
	}

	public static void main(String[] args) {
		int t = fs.nextInt();
		while (t-- > 0) {
			solve();
		}
	}
}
