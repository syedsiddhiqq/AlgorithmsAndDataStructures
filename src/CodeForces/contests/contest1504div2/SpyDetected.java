//package CodeForces.contests.contest1504div2;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 10/04/2021, Saturday, 20:05
 */
public class SpyDetected {
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

	static void solve(){
		int[] freq = new int[101];
		int n = fs.nextInt();

		int[] index = new int[101];
		for(int i=0;i<n;i++){
			int temp = fs.nextInt();
			++freq[temp];
			index[temp] = i;
		}


		for(int i=0;i<101;i++){
			if(freq[i] == 1){
				System.out.println(index[i]+1);
				return;
			}
		}
	}

	public static void main(String[] args){
		int t = fs.nextInt();
		while(t--> 0){
			solve();
		}
	}
}
