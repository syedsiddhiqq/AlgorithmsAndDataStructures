package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 08/04/2021, Thursday, 22:10
 */
public class RandomTeams {
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

	static int combinations(int n) {
		--n;
		return n * (n+1)/2;
	}

	public static void main(String[] args) {
		int n = fs.nextInt();
		int teams = fs.nextInt();

		if (teams == 1) {
			System.out.println(combinations(n) + " " + combinations(n));
		} else {
			int kmax = combinations(n - (teams - 1));
			int kmin = teams/2 + combinations((n - ((teams/2 ) * 2 + teams % 2)));
			System.out.println(kmin + " " + kmax);
		}
	}
}
