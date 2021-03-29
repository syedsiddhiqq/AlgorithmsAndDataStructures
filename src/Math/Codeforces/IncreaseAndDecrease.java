package Math.Codeforces;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 29/03/2021, Monday, 23:42
 * https://codeforces.com/problemset/problem/246/B
 */
public class IncreaseAndDecrease {
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

	public static void main(String[] args) {
		int n = fs.nextInt();
		int[] arr = new int[n];

		int sum =0;
		for(int i=0;i<n;i++){
			arr[i] = fs.nextInt();
			sum+=arr[i];
		}

		if(sum % n == 0){
			System.out.println(n);
		}else{
			System.out.println(n-1);
		}
	}
}
