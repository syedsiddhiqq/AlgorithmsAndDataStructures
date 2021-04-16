package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 16/04/2021, Friday, 14:08
 */
public class Polygon {
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

	static boolean checkOutOfBounds(int i, int j, int n) {
		if (i < 0 || j < 0 || i >= n || j >= n) {
			return false;
		}
		return true;
	}

	static void solve() {
		int n = fs.nextInt();
		char[][] grid = new char[n][n];
		for (int i = 0; i < n; i++) {
			grid[i] = fs.nextString().toCharArray();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					boolean one = false;
					// to check down if 1
					if (i + 1 < n) {
						if (grid[i + 1][j] == '1') {
							one = true;
						}
					}
					if (!one && j + 1 < n) {
						if (grid[i][j + 1] == '1') {
							one = true;
						}
					}
					if (!one && i == n - 1) {
						one = true;
					}
					if (!one && j == n - 1) {
						one = true;
					}

					if (!one) {
						System.out.println("NO");
						return;
					}
				}
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
