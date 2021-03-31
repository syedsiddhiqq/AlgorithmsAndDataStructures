//package Math.Codeforces;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 01/04/2021, Thursday, 03:40
 */
public class OddSelection {
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

	static void solve() {
		int n, x;
		n = fs.nextInt();
		x = fs.nextInt();
		int[] arr = new int[n];
		int oddCount = 0, evenCount = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = fs.nextInt();
			if (arr[i] % 2 != 0) oddCount++;
		}

		evenCount = n - oddCount;

		boolean flag = false;
		for(int i=1;i<=oddCount && i <= x ;i+=2){
			if(evenCount >= x - i){
				flag = true;
				break;
			}
		}

		System.out.println(flag ? "Yes" : "No");

	}

	public static void main(String[] args) {
		int t = fs.nextInt();
		while (t-- > 0) {
			solve();
		}
	}
}
