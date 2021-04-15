package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 16/04/2021, Friday, 01:08
 */
public class ProductOfThreeNums {
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

	static void primeFactors(long n, List<Long> factors) {
		// Print the number of 2s that divide n
		while (n % 2 == 0) {
			factors.add((long) 2);
			n /= 2;
		}

		// n must be odd at this point.  So we can
		// skip one element (Note i = i +2)
		for (long i = 3; i <= Math.sqrt(n); i += 2) {
			// While i divides n, print i and divide n
			while (n % i == 0) {
				factors.add(i);
				n /= i;
			}
		}

		// This condition is to handle the case whien
		// n is a prime number greater than 2
		if (n > 2)
			factors.add(n);
	}

	static void solve() {
		long n = fs.nextLong();
		List<Long> factors = new ArrayList<>();
		primeFactors(n, factors);

		long a, b = 0, c = 0;
		a = factors.get(0);

		if (factors.size() == 3) {
			b = factors.get(1);
			c = factors.get(2);
		}else{
			if (factors.size() > 2) {
				b = factors.get(1) * factors.get(2);
			}
			if (factors.size() > 3) {
				c = 1;
				for (int i = 3; i < factors.size(); i++) {
					c *= factors.get(i);
				}
			}
		}



		if (a > 1 && b > 1 && c > 1 && a != b & a != c && b != c) {
			System.out.println("YES");
			System.out.println(a + " " + b + " " + c);
		} else {
			System.out.println("NO");
		}
	}

	public static void main(String[] args) {
		int t = fs.nextInt();
		while (t-- > 0) {
			solve();
		}
	}
}
