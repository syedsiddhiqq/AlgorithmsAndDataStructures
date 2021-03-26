//package CodeForces.practice.cr710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Syed Ali.
 * @createdAt 26/03/2021, Friday, 10:17
 */
public class PartialReplacement {
	static class Fs {
		private BufferedReader bufferedReader;
		private StringTokenizer stt;


		public Fs() {
			this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		}

		public String nextLine() {
			try {
				return bufferedReader.readLine();
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
		int n, k;
		n = fs.nextInt();
		k = fs.nextInt();
		String s = fs.nextLine();
		char[] str = s.toCharArray();
		boolean initialX = false;
		int distance = 0;
		int indexOfLastX = 0;
		int answer = 0;
		for (int i = 0; i < n; i++) {
			char ch = str[i];
			if (ch == '*' && !initialX) {
				str[i] = 'x';
				initialX = true;
				distance = -1;
				answer++;
			}
			++distance;

			if (distance > k && initialX) {
				if (str[indexOfLastX] != 'x') {
					str[indexOfLastX] = 'x';
					distance = i - indexOfLastX;
					answer++;
				} else if (str[i] == '*') {
					str[i] = 'x';
					distance = 0;
					answer++;
				}
			}

			if (ch == '*') {
				indexOfLastX = i;
			}
		}

		if (str[indexOfLastX] != 'x') {
			str[indexOfLastX] = 'x';
			answer++;
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
