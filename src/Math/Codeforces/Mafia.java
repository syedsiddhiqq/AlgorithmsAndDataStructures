//package Math.Codeforces;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 01/04/2021, Thursday, 01:09
 */
public class Mafia {
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

	public static void main(String[] args) {
		int n = fs.nextInt();
		long sum  = 0;
		long max = 0;
		for(int i=0;i<n;i++){
			long temp = fs.nextInt();
			sum+=temp;
			max = Math.max(max,temp);
		}

		long answer = 0;
		while(sum > 0){
			sum-=n-1;
			++answer;
		}
		System.out.println(Math.max(answer,max));
	}
}
