//package CodeForces.RoadMap.D2_A;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 04/04/2021, Sunday, 14:41
 */
public class VasillaTheWise {
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
		int r1, r2, c1, c2, d1, d2;
		r1 = fs.nextInt();
		r2 = fs.nextInt();
		c1 = fs.nextInt();
		c2 = fs.nextInt();
		d1 = fs.nextInt();
		d2 = fs.nextInt();
		boolean solutionFound = false;
		for (int i = 1; i <= 9; i++) {
			int w = i;
			int x = r1 > i ? r1 - i : i - r1;
			int y = d2 > x ? d2 - x : x - d2;
			int z = d1 > i ? d1 - i : i - d1;

			if (x > 0 && x < 10 && y > 0 && y < 10 && z > 0 && z < 10 && w != x
					&& w != y && w != z && x != y && x != z
					&& y != z && y + z == r2 && w + y == c1 && x + z == c2) {
				solutionFound = true;
				System.out.println(w + " " + x);
				System.out.println(y + " " + z);
			}
		}
		if (!solutionFound) {
			System.out.println(-1);
		}
	}
}
