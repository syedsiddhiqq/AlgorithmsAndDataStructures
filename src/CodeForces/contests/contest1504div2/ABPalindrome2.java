package CodeForces.contests.contest1504div2;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 10/04/2021, Saturday, 21:22
 */
public class ABPalindrome2 {
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

	static void printStr(int a, int b){
		StringBuilder res = new StringBuilder();
		if(a > 0 && b > 0){
			for (int i = 0; i < a / 2; i++) {
				res.append(0);
			}

			for (int i = 0; i < b / 2; i++) {
				res.append(1);
			}
		}else{
			if(a == 0){
				for (int i = 0; i < b; i++) {
					res.append(1);
				}
			}else{
				for (int i = 0; i < a; i++) {
					res.append(0);
				}
			}
		}

		if(a > 1 || b > 1){
			System.out.println(res + "" + res.reverse());
		}else{
			System.out.println(res);
		}

	}

	static void solve() {
		int a, b;
		a = fs.nextInt();
		b = fs.nextInt();
		char[] str = fs.nextString().toCharArray();
		int countOfZero = a;
		int countOfOne = b;
		int countOfQuestion = 0;

		if (a > 0 && b > 0 && a % 2 != 0 && b % 2 != 0) {
			System.out.println(-1);
			return;
		}

		for (int i = 0; i < str.length; i++) {
			if (str[i] == '0') {
			 	--countOfZero;
			} else if (str[i] == '1') {
				--countOfOne;
			} else {
				++countOfQuestion;
			}
		}

		if (countOfQuestion == 0) {
			System.out.println(-1);
		} else {
			if (countOfZero + countOfOne == countOfQuestion) {
				printStr(a,b);
			} else {
				System.out.println(-1);
			}
		}
	}

	public static void main(String[] args) {
		int t = fs.nextInt();
		while (t-- > 0) {
			solve();
		}
	}
}
