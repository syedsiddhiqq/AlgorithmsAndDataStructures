//package Math.Codeforces;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 31/03/2021, Wednesday, 01:55
 */
public class OppositesAttract {
	static class Fs{
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

		public long nextLong(){ return Long.parseLong(nextString()); }
	}

	static Fs fs = new Fs();

	public static void main(String[] args) {
		int n = fs.nextInt();
		int[] arr = new int[n];
		long[] r = new long[21];
		for (int j = 0; j < n; ++j)
			arr[j] = fs.nextInt();

		for(int j=0;j<n;j++){
			r[arr[j] + 10]++;
		}
		long c = 0;
		for (int j = 0; j < 10; ++j)
			c += r[j] * r[20 - j];
		if (r[10] > 0) c += (r[10] * (r[10] - 1))/2;
		System.out.println(c);
	}
}
