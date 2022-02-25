package CodeForces.RoadMap.D2_A;



import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 12/04/2021, Monday, 20:19
 */
public class GcdXy {
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

	static long gcd(long a, long b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	static int countDigits(long a){
		int count = 0;
		while(a > 0) {
			++count;
			a=a/10;
		}
		return count;
	}

	static long generateDecimal(int n){
		--n;
		long a = 1;
		while(n -- > 0){
			a = a * 10;
		}
		return a;
	}

	static void solve() {
		// Function to solve
		int a,b,c;
		a = fs.nextInt();
		b = fs.nextInt();
		c = fs.nextInt();

//		long start  = generateDecimal(a);
//		long end = generateDecimal(b);
//
//		while(start < end){
//			if(countDigits(gcd(start,end)) == c){
//				System.out.println(start + " " + end);
//				return;
//			}
//			++start;
//		}
		System.out.println(gcd(a,b));
	}

	public static void main(String[] args) {
		int t = fs.nextInt();
		while (t-- > 0) {
			solve();
		}
	}
}
