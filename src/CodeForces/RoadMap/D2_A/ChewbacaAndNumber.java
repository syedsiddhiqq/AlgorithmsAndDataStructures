package CodeForces.RoadMap.D2_A;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 04/04/2021, Sunday, 15:33
 */
public class ChewbacaAndNumber {
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
		long n = fs.nextLong();
		StringBuilder result = new StringBuilder();
		while(n > 0){
			long a = Math.min(9 - n % 10, n % 10);
			if( a == 0){
				if(n / 10 <= 0){
					a = n%10;
				}
			}
			result.append(a);
			n = n/10;
		}
		System.out.println(result.reverse());
	}
}
