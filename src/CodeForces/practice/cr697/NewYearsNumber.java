package CodeForces.practice.cr697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Syed Ali.
 * @createdAt 23/03/2021, Tuesday, 14:48
 */
public class NewYearsNumber {
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

	static void solve(){
		int n = fs.nextInt();
		int countOf2021 = n % 2020;
		int countOf2020 = (n - countOf2021)/2020 - countOf2021;
		if(countOf2020 >= 0 && (2020 * countOf2020 + 2021 * countOf2021 == n))
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	public static void main(String[] args) {
		int  t= fs.nextInt();
		while(t-- > 0) {
			solve();
		}
	}
}
