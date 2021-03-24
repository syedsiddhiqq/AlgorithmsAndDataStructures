package CodeForces.practice.cr697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Syed Ali.
 * @createdAt 23/03/2021, Tuesday, 09:52
 */
public class OddDivisor {
	static class Fs{
		private BufferedReader bufferedReader;
		private StringTokenizer stt;


		public Fs(){
			this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		}

		public String nextLine() {
			try{
				return bufferedReader.readLine();
			}catch (IOException e){
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

		public long nextLong() { return Long.parseLong(nextString());}
	}

	static Fs fs = new Fs();

	static boolean checkIfOddDivisorExists(long n){
		boolean flag = false;
		while(n > 1){
			n = n/2;
			if(n > 1 && n % 2 != 0) {
				flag = true;
			}
		}

		return flag;
	}


	static void solve(){
		long n = fs.nextLong();
		if(n > 1 && n % 2 != 0 ) System.out.println("YES");
		else {
			System.out.println(checkIfOddDivisorExists(n) ? "YES" : "NO");
		}
	}

	public static void main(String[] args) {
		long t = fs.nextLong();
		while(t-- >0){

			solve();
		}
	}
}
