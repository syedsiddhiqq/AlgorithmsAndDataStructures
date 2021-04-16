//package CodeForces.RoadMap.D2_A;


import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 16/04/2021, Friday, 20:14
 */
public class AverageHeight {
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
		List<Integer> odd = new ArrayList<>();
		List<Integer> even = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int temp = fs.nextInt();
			if (temp % 2 == 0) {
				even.add(temp);
			} else {
				odd.add(temp);
			}
		}

		for (int i = 0; i < odd.size(); i++) {
			System.out.print(odd.get(i) + " ");
		}

		for (int i = 0; i < even.size(); i++) {
			System.out.print(even.get(i) + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int t = fs.nextInt();
		while (t-- > 0) {
			solve();
		}
	}
}
