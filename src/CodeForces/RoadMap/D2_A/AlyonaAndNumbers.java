//package CodeForces.RoadMap.D2_A;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 04/04/2021, Sunday, 03:25
 */
public class AlyonaAndNumbers {
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
		int n,m;
		n = fs.nextInt();
		m = fs.nextInt();

		long pairs = 0;
		for(int i=1;i<=n;i++)
			pairs+=(i+m)/5-i/5;
		System.out.println(pairs);
	}
}
