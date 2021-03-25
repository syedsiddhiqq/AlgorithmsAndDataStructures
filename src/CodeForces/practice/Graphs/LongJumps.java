//package CodeForces.practice.Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Syed Ali.
 * @createdAt 25/03/2021, Thursday, 01:55
 */
public class LongJumps {

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

	static void solve(){
		int n = fs.nextInt();
		int[] arr = new int[n+1];

		List<List<Integer>> adjacency = new ArrayList<>();

		for(int i=0;i<n;i++){
			arr[i] = fs.nextInt();
		}

		int max = Integer.MIN_VALUE;
		int[] dp = new int[n];
		for(int i=n-1; i >=0 ;i--){
			dp[i] = arr[i];
			if(i + arr[i] < n ){
				dp[i] += dp[i + arr[i]];
			}
			max = Math.max(max,dp[i]);
		}
		System.out.println(max);

	}

	public static void main(String[] args) {
		int t = fs.nextInt();
		while(t-->0){
			solve();
		}
	}

}
