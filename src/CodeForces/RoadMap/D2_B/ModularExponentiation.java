package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 05/04/2021, Monday, 22:29
 */
public class ModularExponentiation {
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

	static long modExp(long b, long p, long m) {
		if (p == 0) {
			return 1;
		} else if (p % 2 == 0) {
			long y = modExp(b, p / 2, m);
			return (y * y) % m;
		} else {
			return ((b % m) * modExp(b, p - 1, m)) % m;
		}
	}

	public static void main(String[] args) {
		long b = fs.nextInt();
		long p = fs.nextInt();
		long m = fs.nextInt();
		System.out.println(modExp(b, p, m));
	}
}
