package CodeForces.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Syed Ali.
 * @createdAt 20/09/2021, Monday, 20:58
 */
public class SlayTheDragon {
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

	private static int lowerBound(Long[] a, int start, int end, Long x) {
		while (start < end) {
			int m = (start + end) >>> 1;
			if (a[m] >= x) end = m;
			else start = m + 1;
		}
		return start;
	}

	static Fs fs = new Fs();

	public static void main(String[] args) {
		int n = fs.nextInt();
		Long[] heroes = new Long[n];
		long sum = 0;
		for (int i = 0; i < n; i++) {
			heroes[i] = fs.nextLong();
			sum += heroes[i];
		}

		Arrays.sort(heroes);
		int nDragons = fs.nextInt();

		long strength, power;
		for (int i = 0; i < nDragons; i++) {
			long coins = 0;
			strength = fs.nextLong();
			power = fs.nextLong();
			int index = lowerBound(heroes, 0, n, strength);
			if (index == 0) {
				if (sum - heroes[index] < power) {
					coins += power - (sum - heroes[index]);
				}
			} else if (index != n) {
				long a = 0, b = 0;
				if (heroes[index] < strength) {
					a += strength - heroes[index];
				}
				if (sum - heroes[index] < power) {
					a += power - (sum - heroes[index]);
				}
				if (heroes[index - 1] < strength) {
					b += strength - heroes[index - 1];
				}
				if (sum - heroes[index - 1] < power) {
					b += power - (sum - heroes[index - 1]);
				}
				coins = Math.min(a, b);
			} else {
				if (heroes[index - 1] < strength) {
					coins += strength - heroes[index - 1];
				}

				if (sum - heroes[index - 1] < power) {
					coins += power - (sum - heroes[index - 1]);
				}
			}
			System.out.println(coins);
		}
	}
}
