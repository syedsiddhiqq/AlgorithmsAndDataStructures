//package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 06/04/2021, Tuesday, 05:28
 */
public class SummerSellOff {
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

	static class Day implements Comparator<Day> {
		long x;
		int y;

		Day() {

		}

		Day(long x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compare(Day o1, Day o2) {
			if (o1.x < o2.x) {
				return -1;
			}
			if (o1.x > o2.x) {
				return 1;
			}
			return 0;
		}
	}

	public static void main(String[] args) {
		int n = fs.nextInt();
		int f = fs.nextInt();
		List<Day> days = new ArrayList<>();
		long[] k = new long[n];
		long[] l = new long[n];
		for (int i = 0; i < n; i++) {
			k[i] = fs.nextLong();
			l[i] = fs.nextLong();
			days.add(new Day(Math.min(2 * k[i], l[i]) - Math.min(k[i], l[i]), i));
		}
		days.sort(new Day());
		long answer = 0;
		int i;
		for (i = n - 1; i >= n - f; i--) {
			answer += Math.min(2 * k[days.get(i).y], l[days.get(i).y]);
		}

		for (; i >= 0; i--) {
			answer += Math.min(k[days.get(i).y], l[days.get(i).y]);
		}
		System.out.println(answer);
	}
}