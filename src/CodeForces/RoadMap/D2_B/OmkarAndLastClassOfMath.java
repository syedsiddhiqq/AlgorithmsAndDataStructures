package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 16/04/2021, Friday, 02:47
 */
public class OmkarAndLastClassOfMath {
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

	// Recursive method to return gcd of a and b
	static long gcd(long a, long b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}

	// method to return LCM of two numbers
	static long lcm(long a, long b) {
		return (a / gcd(a, b)) * b;
	}


	static void solve() {
		long n = fs.nextLong();
		if( n % 2 == 0){
			System.out.println(n /2 + " " + n/2);
		}else{
			for(int i=2;i*i <= n ;i++){
				if(n % i == 0){
					System.out.println(n/i + " " + (n - (n/i))) ;
					return;
				}
			}
			System.out.println(1 + " " + (n-1));
		}
	}

	public static void main(String[] args) {
		int t = fs.nextInt();
		while (t-- > 0) {
			solve();
		}
	}
}
