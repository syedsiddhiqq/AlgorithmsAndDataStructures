package Math.SPOJ;


import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 31/03/2021, Wednesday, 02:39
 */
public class EvenCount {
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

	static boolean checkEven(int a){
		while(a>0){
			if((a % 10) % 2 == 0){
				return true;
			}
			a = a/10;
		}
		return false;
	}

	static void solve(){
		int l,r;
		l = fs.nextInt();
		r = fs.nextInt();


		int answer = 0;
		for(int i=l;i<=r;i++){
			if(checkEven(i)){
				answer++;
			}
		}
		System.out.println(answer);
	}

	public static void main(String[] args) {
		int t = fs.nextInt();
		while(t-- > 0){
			solve();
		}
	}
}
