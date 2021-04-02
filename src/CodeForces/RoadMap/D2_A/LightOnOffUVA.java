package CodeForces.RoadMap.D2_A;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 02/04/2021, Friday, 01:52
 */
public class LightOnOffUVA {
	static int MAX = (int) (4 * Math.pow(10,9));
	static long factor[];

	// function to generate all prime
	// factors of numbers from 1 to 10^6
	static void generatePrimeFactors() {
		factor[1] = 1;

		// Initializes all the positions with
		// their value.
		for (int i = 2; i < MAX; i++)
			factor[i] = i;

		// Initializes all multiples of 2 with 2
		for (int i = 4; i < MAX; i += 2)
			factor[i] = 2;

		// A modified version of Sieve of
		// Eratosthenes to store the
		// smallest prime factor that
		// divides every number.
		for (int i = 3; i * i < MAX; i++) {
			// check if it has no prime factor.
			if (factor[i] == i) {
				// Initializes of j starting from i*i
				for (int j = i * i; j < MAX; j += i) {
					// if it has no prime factor
					// before, then stores the
					// smallest prime divisor
					if (factor[j] == j)
						factor[j] = i;
				}
			}
		}
	}

	// function to calculate number of factors
	static int calculateNoOFactors(long n) {
		if (n == 1)
			return 1;

		int ans = 1;

		// stores the smallest prime number
		// that divides n
		int index = (int) n;
		long dup = factor[index];

		// stores the count of number of times
		// a prime number divides n.
		int c = 1;

		// reduces to the next number after prime
		// factorization of n
		long j = n / factor[index];
		int indexOfJ = (int) j;

		// false when prime factorization is done
		while (j != 1) {
			// if the same prime number is dividing n,
			// then we increase the count
			if (factor[indexOfJ] == dup)
				c += 1;

            /* if its a new prime factor that is
               factorizing n, then we again set c=1
               and change dup to the new prime factor,
               and apply the formula explained
               above. */
			else {
				dup = factor[indexOfJ];
				ans = ans * (c + 1);
				c = 1;
			}

			// prime factorizes a number
			j = j / factor[indexOfJ];
		}

		// for the last prime factor
		ans = ans * (c + 1);

		return ans;
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

	static void solve(long n) {
		System.out.println(calculateNoOFactors(4));
	}

	public static void main(String[] args) {
			factor = new long[MAX];
		factor[0] = 0;
		generatePrimeFactors();
		while (true) {
			long n = fs.nextInt();
			if (n != 0) {
				solve(n);
			} else {
				break;
			}
		}
	}
}
