package CodeForces.unsolved;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 07/04/2021, Wednesday, 14:12
 */
public class KingsPath {
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
		long x1, y1, x2, y2;
		x1 = fs.nextLong();
		y1 = fs.nextLong();
		x2 = fs.nextLong();
		y2 = fs.nextLong();
		long maxRow = Math.max(x1, x2);
		long maxCol = Math.max(y1, y2);

		int n = fs.nextInt();
		List<List<Long>> values = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			List<Long> temp = new ArrayList<>();
			long row = fs.nextLong();
			long a = fs.nextLong();
			long b = fs.nextLong();

			maxRow = Math.max(maxRow, row);
			maxCol = Math.max(maxCol, b);
			temp.add(row);
			temp.add(a);
			temp.add(b);
		}
//		long[][] chess = new long[maxRow][maxCol];
	}
}
