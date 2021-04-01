//package CodeForces.practice.implementation;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 01/04/2021, Thursday, 15:05
 */
public class TernaryXor {
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
		int n = fs.nextInt();
		String s =fs.nextString();
		char[] str = s.toCharArray();
		StringBuilder a=new StringBuilder();
		StringBuilder b=new StringBuilder();
		boolean flag = false;
		for (int i = 0; i < str.length; i++) {
			char ch = str[i];
			if (!flag) {
				if (ch == '2') {
					a.append("1");
					b.append("1");
				} else if (ch == '1') {
					a.append("1");
					b.append("0");
					flag = true;
				} else {
					a.append("0");
					b.append("0");
				}
			}else{
				a.append("0");
				b.append(ch);
			}
		}
		System.out.println(a);
		System.out.println(b);
	}

	public static void main(String[] args) {
		int t = fs.nextInt();
		while (t-- > 0) {
			solve();
		}
	}
}
