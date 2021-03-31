//package Math.Codeforces;


import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 31/03/2021, Wednesday, 11:15
 */
public class TriangularNumber {
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

	static int[] arr = new int[501];

	static void precalculate(){
		int n = 1;
		while(true){
			int t =  (n * (n+1))/2;
			if(t > 500){
				break;
			}
			arr[t] = 1;
			++n;
		}
	}

	public static void main(String[] args) {
		precalculate();
		int n = fs.nextInt();
		if(arr[n] == 1){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	}
}
