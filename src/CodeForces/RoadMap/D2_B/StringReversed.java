package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 05/04/2021, Monday, 23:02
 */
public class StringReversed {
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

	static String addTwoStrings(StringBuilder a, StringBuilder b) {
		StringBuilder res = new StringBuilder();
		int carry = 0;
		int aPointer = a.length() - 1;
		int bPointer = b.length() - 1;
		while (aPointer >= 0 && bPointer >= 0) {
			int sum = Integer.parseInt(a.charAt(aPointer) + "") + Integer.parseInt(b.charAt(bPointer) + "") + carry;
			carry = 0;
			int c = (sum / 10) % 10;
			carry += Math.max(c, 0);
			res.append(sum % 10);
			--aPointer;
			--bPointer;
		}
		if(aPointer >= 0){
			res.append(Integer.parseInt(a.charAt(aPointer)+"")+carry);
			res.append(a,0, aPointer == 0 ? 0 : aPointer + 1);
		}else if(carry > 0) res.append(carry);
		return res.reverse().toString();
	}

	static void solve() {
		String a = fs.nextString();
		String b = fs.nextString();

		StringBuilder strA = new StringBuilder(a);
		StringBuilder strB = new StringBuilder(b);

//		strA = strA.reverse();
//		strB = strB.reverse();
		System.out.println(addTwoStrings(strA,strB));
	}

	public static void main(String[] args) {
		int t = fs.nextInt();
		while (t-- > 0) {
			solve();
		}
	}
}
