//package CodeForces.RoadMap.D2_A;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 04/04/2021, Sunday, 14:14
 */
public class MountainScenary {
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

	public static void main(String[] args) {
		int n, k;
		n = fs.nextInt();
		k = fs.nextInt();

		int length = 2 * n + 2;
		int[] arr = new int[length];
		for (int i = 1; i < length; i++) {
			arr[i] = fs.nextInt();
		}

		for (int i = 1; i < length; i++) {
			if (i % 2 == 0) {
				if (k > 0 && (arr[i] - 1 > arr[i - 1] && arr[i] - 1 > arr[i + 1] ) ) {
					--k;
					--arr[i];
				}
			}
		}
		for (int i = 1; i < length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
