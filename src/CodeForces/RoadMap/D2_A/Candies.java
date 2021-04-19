package CodeForces.RoadMap.D2_A;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 18/04/2021, Sunday, 22:12
 */
public class Candies {
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
		int oddSum = 0;
		int evenSum = 0;
		int evenCount = 0;
		int oddCount = 0;
		for (int i = 0; i < n; i++) {
			int temp = fs.nextInt();
			if (temp % 2 == 0) {
				oddSum += temp;
				++oddCount;
			} else {
				evenSum += temp;
				++evenCount;
			}
		}

		if (oddSum == evenSum || (oddSum == 0 && evenCount % 2 == 0) || (evenSum == 0 && oddCount % 2 == 0) || (oddSum != 0 && evenSum != 0 && (oddSum + evenSum) % 2 == 0)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	public static void main(String[] args) {
		int t = fs.nextInt();
		while (t-- > 0) {
			solve();
		}
	}
}
