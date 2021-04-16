//package CodeForces.RoadMap.D2_C1;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 16/04/2021, Friday, 14:28
 */
public class SocialDistance {
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
		int k = fs.nextInt();
		char[] str = fs.nextString().toCharArray();
		int answer = 0;

		for (int i = 0; i < n; ) {
			int temp = i;
			if (str[i] == '0') {
				for (int j = i; j <= (i + k) && j < n; j++) {
					if (str[j] == '1') {
						temp = j;
					}
				}

				if (temp == i) {
					++answer;
				}
			}
			i = temp + k + 1;
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
