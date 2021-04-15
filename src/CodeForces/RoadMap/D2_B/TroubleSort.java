package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 16/04/2021, Friday, 01:45
 */
public class TroubleSort {
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

	static void swap(int[] arr, int i , int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static void solve() {
		int n = fs.nextInt();
		int[] arr = new int[n];
		int[] type = new int[n];
		boolean needsSort = false;
		arr[0] = fs.nextInt();
		for (int i = 1; i < n; i++) {
			arr[i] = fs.nextInt();
			if (arr[i] < arr[i - 1]) {
				needsSort = true;
			}
		}

		int countOfZero = 0;
		int countOfOnes = 0;
		for (int i = 0; i < n; i++) {
			type[i] = fs.nextInt();
			if (type[i] == 0) countOfZero++;
			else countOfOnes++;
		}

		if (!needsSort) {
			System.out.println("Yes");
		} else if (countOfOnes == n || countOfZero == n) {
			System.out.println("No");
		} else {
			System.out.println("Yes");
		}
	}

	public static void main(String[] args) {
		int t = fs.nextInt();
		while (t-- > 0) {
			solve();
		}
	}
}
