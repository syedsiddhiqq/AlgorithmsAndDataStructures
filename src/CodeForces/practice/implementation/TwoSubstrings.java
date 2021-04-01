//package CodeForces.practice.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Syed Ali.
 * @createdAt 01/04/2021, Thursday, 18:03
 */
public class TwoSubstrings {

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
		String s = fs.nextString();
		if ((s.contains("AB") && s.replaceFirst("AB", ".").contains("BA")) || s.contains("BA") && s.replaceFirst("BA",
				".").contains("AB"))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
