//package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 19/04/2021, Monday, 23:33
 */
public class BallInBerland {
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

	static Fs sc = new Fs();

	public static void solve() {
		int a = sc.nextInt();
		int b = sc.nextInt();
		int k = sc.nextInt();
		int[][] edges = new int[k][2];
		long[] db = new long[a];
		long[] dg = new long[b];
		for (int i=0; i<k; i++) {
			edges[i][0] = sc.nextInt()-1;
			db[edges[i][0]]++;
		}
		for (int i=0; i<k; i++) {
			edges[i][1] = sc.nextInt()-1;
			dg[edges[i][1]]++;
		}
		long ans = 0;
		for (int i=0; i<k; i++) {
			int boy = edges[i][0];
			int girl = edges[i][1];
			ans += k-db[boy]-dg[girl]+1;
		}
		System.out.println(ans/2);
	}

	public static void main(String[] args) {
		int t = sc.nextInt();
		while (t-->0) solve();
	}
}
