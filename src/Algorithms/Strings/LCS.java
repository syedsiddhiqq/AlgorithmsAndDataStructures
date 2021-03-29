package Algorithms.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Syed Ali.
 * @createdAt 29/03/2021, Monday, 14:23
 */
public class LCS {

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

	}

	static Fs fs = new Fs();

	static String solve(String x, String y){
		int xLength = x.length();
		int yLength = y.length();

		// dp initialization
		int[][] dp = new int[xLength+1][yLength+1];

		// Max length of substring
		int max = -1;
		int maxSubstringEndingIndex = 0;

		for(int i=0;i<=xLength;i++){
			for(int j=0;j<=yLength;j++){
				if(i == 0 || j == 0){
					dp[i][j] = 0;
				}else if(x.charAt(i-1) == y.charAt(j-1)){
					dp[i][j] = 1 + dp[i-1][j-1];
					if(max < dp[i][j]){
						max = dp[i][j];
						maxSubstringEndingIndex = j;
					}
				}else{
					dp[i][j] = 0;
				}
			}
		}

		String result = "";
		int startIndex = maxSubstringEndingIndex - max;
		for(int j=startIndex; j < maxSubstringEndingIndex ;j++){
			result += y.charAt(j);
		}
		return result;
	}

	public static void main(String[] args) {
		String s = fs.nextString();
		String s1 = fs.nextString();
		System.out.println(solve(s,s1));
	}
}
