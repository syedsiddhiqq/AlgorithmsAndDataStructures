//package Math.Codeforces;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 29/03/2021, Monday, 23:57
 */
public class LittleElephantAndFunction {
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
		int n = fs.nextInt();
		for(int i=2;i<=n;i++){
			System.out.print(i + " ");
		}
		System.out.print(1);
	}
}
