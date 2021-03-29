//package CodeForces.contests.codecraftcrdiv2711;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Syed Ali.
 * @createdAt 29/03/2021, Monday, 20:04
 */
public class A {
	public static long gcd(long a, long b) {
		if (a == 0)
			return b;

		return gcd(b % a, a);
	}

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

	static long sumOfDigits(long n){
		int sum = 0;
		while(n>0){
			sum+=n%10;
			n=n/10;
		}
		return sum;
	}


	static void solve(){
		long n = fs.nextLong();

		while(gcd(n,sumOfDigits(n)) <= 1){
			n++;
		}
		System.out.println(n);
	}

	public static void main(String[] args) {
		int t = fs.nextInt();
		while(t-->0){
			solve();
		}
	}
}
