package CodeForces.contests.contest1504div2;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 10/04/2021, Saturday, 20:50
 */
public class ABPalindrome {
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

	static boolean isPalindrome(String str) {

		// Pointers pointing to the beginning
		// and the end of the string
		int i = 0, j = str.length() - 1;

		// While there are characters to compare
		while (i < j) {

			// If there is a mismatch
			if (str.charAt(i) != str.charAt(j))
				return false;

			// Increment first pointer and
			// decrement the other
			i++;
			j--;
		}

		// Given string is a palindrome
		return true;
	}

	static void solve() {
		int a, b;
		a = fs.nextInt();
		b = fs.nextInt();
		char[] str = fs.nextString().toCharArray();
		int n = str.length;
		for (int i = 0; i < (n / 2 > 0 ? n /2 : 1); i++) {
			if (str[i] == '0' && str[n - i - 1] == '0') {
				a = a - 2;
			} else if (str[i] == '1' && str[n - i - 1] == '1') {
				b = b - 2;
			}

			if (str[i] == '1' && str[n - i - 1] == '?') {
				if (b > 0) {
					str[n - i - 1] = '1';
					b = b - 2;
				} else {
					System.out.println(-1);
					return;
				}
			} else if (str[i] == '0' && str[n - i - 1] == '?') {
				if (a > 0) {
					str[n - i - 1] = '1';
					a = a - 2;
				} else {
					System.out.println(-1);
					return;
				}
			}

			if (str[i] == '?' && str[n - i - 1] == '1') {
				if (b > 0) {
					str[i] = '1';
					b = b - 2;
				} else {
					System.out.println(-1);
					return;
				}
			} else if (str[i] == '?' && str[n - i - 1] == '0') {
				if (a > 0) {
					str[i] = '0';
					a = a - 2;
				} else {
					System.out.println(-1);
					return;
				}
			} else if (str[i] == '?') {
				if(a > 0 && i == n-i-1){
					str[i] = '0';
					--a;
				}else if(b > 0 && i == n-i-1){
					str[i] = '1';
					--b;
				}else if (a >= 2) {
					str[i] = '0';
					str[n - i - 1] = '0';
					a = a - 2;
				} else if (b >= 2) {
					str[i] = '1';
					str[n - i - 1] = '1';
					b = b - 2;
				} else {
					System.out.println(-1);
					return;
				}
			}
		}

		String s = String.valueOf(str);
		if (a == 0 && b == 0 && isPalindrome(s)) {
			System.out.println(s);
		} else {
			System.out.println(-1);
		}
	}

	public static void main(String[] args) {
		int t = fs.nextInt();
		while (t-- > 0) {
			solve();
		}
	}
}
