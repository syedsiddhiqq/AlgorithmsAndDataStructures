package CodeForces.contests.contest1504div2;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 03/04/2021, Saturday, 19:57
 */
public class A {

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

	static boolean checkIfOnlyA(String s) {
		char[] str = s.toCharArray();
		int count = 0;
		for (int i = 0; i < str.length; i++) {
			if (str[i] == 'a') {
				count++;
			}
		}
		return count == str.length;
	}

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
		String s = fs.nextString();
		if (!checkIfOnlyA(s)) {
			System.out.println("YES");
			String result1 = "a" + s;
			String result2 = s + "a";
			System.out.println(isPalindrome(result1) ? result2 : result1);
		} else {
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
