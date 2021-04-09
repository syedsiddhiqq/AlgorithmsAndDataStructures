package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 09/04/2021, Friday, 15:14
 */
public class Tprimes {
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

	static boolean tPrime(long n){
		int count = 2;
		for(int i=2;i <= Math.sqrt(n)+1;i++){
			if(n % i == 0){
				++count;
			}
		}
		return count == 3;
	}

	static void solve(){
		long n = fs.nextLong();
		System.out.println(tPrime(n) ? "YES" : "NO" );
	}

	public static void main(String[] args){
		int t = fs.nextInt();
		while(t-->0){
			solve();
		}
	}
}
