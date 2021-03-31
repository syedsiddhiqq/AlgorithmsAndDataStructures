//package Math.Codeforces;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 01/04/2021, Thursday, 02:08
 */
public class SumOfOddIntegers {
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

	static Fs fs = new Fs();

	static void solve(){
		long n = fs.nextInt();
		long k = fs.nextInt();

		// if k = 3
		// sum of 1st k odd numbers = 1 + 3 + 5 = 9 which is k^2
		// odd + odd = even
		// even + odd = odd
		// k % 2 == 0 then any sum will be even.
		// k % 2 !=0 then any sum will be odd
		if((k % 2 == n % 2) && (n >= k*k)){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}

	}

	public static void main(String[] args) {
		int t = fs.nextInt();
		while(t-->0){
			solve();
		}
	}
}
