package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 14/04/2021, Wednesday, 17:45
 */
public class JzzuAndSequences {
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

	static long k = 1000000007;

	static long retAnswer(long n){
		return ((n % k) + k ) % k;
	}

	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);
		int x, y, n, i, temp;
		int[] a = new int[6];
		x = reader.nextInt();
		y = reader.nextInt();
		n = reader.nextInt();
		a[0] = x;
		a[1] = y;
		for (i = 2; i < 6; i++) {
			a[i] = a[i-1] - a[i-2];
		}
		temp = a[(n-1)%6] % 1000000007;
		while (temp < 0) {
			temp += 1000000007;
		}
		System.out.println(temp);
	}
}
