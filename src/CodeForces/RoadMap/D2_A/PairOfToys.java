package CodeForces.RoadMap.D2_A;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 04/04/2021, Sunday, 21:03
 */
public class PairOfToys {
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

	public static void main(String[] args){
		long n,k;
		n = fs.nextLong();
		k = fs.nextLong();
		long answer = 0;
		long start = k > n ? k - n : n- k;
		long end = 1 + start;
		do {
			answer++;
			start--;
			end++;
		} while (end > 0 && end <= n);
		System.out.println(answer/2);
	}
}
