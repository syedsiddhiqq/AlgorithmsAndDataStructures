//package CodeForces.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Syed Ali.
 * @createdAt 20/09/2021, Monday, 20:21
 */
public class CombinatoricsHw {
	static class Fs {
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

		public long nextLong() {
			return Long.parseLong(nextString());
		}
	}

	static Fs fs = new Fs();

	public static void solve() {
		int[] arr = new int[3];
		arr[0] = fs.nextInt();
		arr[1] = fs.nextInt();
		arr[2] = fs.nextInt();

		int m = fs.nextInt();

		Arrays.sort(arr);

		if(arr[0] == 0 && arr[1] == 0 && arr[2]/2  >= m){
			System.out.println("NO");
		}else if(arr[0]/2 + arr[1]/2 + arr[2]/2 >=m){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	}

	public static void main(String[] args) {


		int t = fs.nextInt();
		while (t-- > 0) {
			solve();
		}
	}
}

