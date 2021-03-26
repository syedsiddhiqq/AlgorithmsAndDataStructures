package HackerRank.Algorithms.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author Syed Ali.
 * @createdAt 27/03/2021, Saturday, 02:34
 */
public class SuperReducedStrings {

	static class Fs {
		private BufferedReader bufferedReader;
		private StringTokenizer stt;


		public Fs() {
			this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		}

		public String nextLine() {
			try {
				return bufferedReader.readLine();
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


	static String reduce(String s){
		char[] str = s.toCharArray();
		for(int i=1;i<str.length;i++){
			if(str[i] != '-' && str[i] == str[i-1]){
				str[i] = '-';
				str[i-1] = '-';
			}
		}

		String result = "";
		for(int i=0;i<str.length ;i++){
			if(str[i] != '-'){
				result+=str[i];
			}
		}
		return (result == "" ? "Empty String" : result);
	}

	static String superReducedString(String s) {
		String prev = s;
		while(true){
			String result = reduce(prev);
			if(result.equals("Empty String") || result.equals(prev)){
				return result;
			}
			prev = result;
		}
	}

	public static void main(String[] args) {
		int t = fs.nextInt();
		while(t-->0){
			String s = fs.nextLine();
			System.out.println(superReducedString(s));
		}
	}
}
