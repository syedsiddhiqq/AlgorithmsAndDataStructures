//package Math.Codeforces;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 01/04/2021, Thursday, 01:29
 */
public class EbonyAndIvory {
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

	public static void main(String[] args) {
		int a = fs.nextInt();
		int b = fs.nextInt();
		int c = fs.nextInt();

		// 4 base cases.
		if(c % a == 0 || c % b == 0){ //  case 1
			System.out.println("Yes");
		}else{
			int max = Math.max(a,b);
			int min = Math.min(a,b);
			int start = c/max;
			boolean flag = false;
			while(start > 0){
				int rem = c - (start * max);
				if(rem % min == 0){
					flag = true;
					break;
				}
				--start;
			}
			System.out.println(flag ? "Yes" : "No");
		}
	}
}
