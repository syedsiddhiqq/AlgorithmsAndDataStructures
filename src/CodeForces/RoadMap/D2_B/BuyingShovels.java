package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 16/04/2021, Friday, 00:13
 */
public class BuyingShovels {
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
		long n = fs.nextLong();
		long k = fs.nextLong();

		long answer = Integer.MAX_VALUE;
		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				if (i <= k) {
					answer = Math.min(answer, n / i);
				}
				if (n / i <= k) {
					answer = Math.min(answer, i);
				}
			}
		}
		System.out.println(answer);
	}

	public static void main(String[] args) {
		int t = fs.nextInt();
		while (t-- > 0) {
			solve();
		}
	}
}
