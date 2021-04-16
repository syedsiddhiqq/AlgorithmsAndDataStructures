//package CodeForces.RoadMap.D2_C1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Syed Ali.
 * @createdAt 17/04/2021, Saturday, 00:03
 */
public class MereArray {
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

	static void solve() {
		int n = fs.nextInt();
		long[] orgArr = new long[n];
		long[] arr = new long[n];
		long min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			long temp = fs.nextLong();
			orgArr[i] = temp;
			arr[i] = temp;

			min = Math.min(min, arr[i]);
		}

		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			if (orgArr[i] != arr[i] && orgArr[i] % min != 0) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

	public static void main(String[] args) {
		int t = fs.nextInt();
		while (t-- > 0) {
			solve();
		}
	}
}
