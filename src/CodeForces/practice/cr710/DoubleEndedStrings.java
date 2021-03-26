package CodeForces.practice.cr710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author Syed Ali.
 * @createdAt 26/03/2021, Friday, 13:10
 */
public class DoubleEndedStrings {
	static class Fs {
		private BufferedReader bufferedReader;
		private StringTokenizer stt;


		public Fs() {
			this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		}

		public String nextLine() {
			try {
				return bufferedReader.readLine();
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

	static void solve(){
		String a = fs.nextLine();
		String b = fs.nextLine();
		char[] arrA = a.toCharArray();
		char[] arrB = b.toCharArray();

		Map<Character,Integer> dataMap = new HashMap<>();
		for(int i=0;i<arrA.length;i++){
			for(int j=0;j<arrB.length;j++){
				if(arrA[i] == arrB[i]){
					dataMap.put(arrA[i],1);
				}
			}
		}

	}

	public static void main(String[] args) {
		int t = fs.nextInt();
		while(t-->0){
			solve();
		}
	}
}
