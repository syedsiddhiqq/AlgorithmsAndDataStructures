package CodeForces.practice.Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Syed Ali.
 * @createdAt 25/03/2021, Thursday, 01:35
 * https://codeforces.com/contest/115/problem/A
 */
public class Party {
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
	public static void main(String[] args) {
		int n = fs.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) arr[i] = fs.nextInt();
		int ans = Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			int temp = i;
			int depth = 1;
			while(arr[temp] != -1){
				temp = arr[temp] - 1;
				depth++;
			}
			ans = Math.max(depth,ans);
		}
		System.out.println(ans);
	}
}
