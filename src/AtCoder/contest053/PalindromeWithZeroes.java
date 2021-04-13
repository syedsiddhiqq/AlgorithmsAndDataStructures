//package AtCoder.contest053;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 11/04/2021, Sunday, 17:36
 */
public class PalindromeWithZeroes {

	// Function that returns true if
	// str is a palindrome
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
		char[] str = fs.nextString().toCharArray();

		if (isPalindrome(String.valueOf(str))) {
			System.out.println("Yes");
		} else {
			int count = 0;
			for (int i = str.length - 1; i >= 0; i--) {
				if (str[i] == '0') {
					++count;
				} else {
					break;
				}
			}

			StringBuilder newStr = new StringBuilder();
			for (int i = 0; i < count; i++) {
				newStr.append(0);
			}
			newStr.append(str);
			if (isPalindrome(newStr.toString())) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}
}
