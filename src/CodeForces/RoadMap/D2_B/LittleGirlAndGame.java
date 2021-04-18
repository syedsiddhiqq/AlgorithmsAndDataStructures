package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 17/04/2021, Saturday, 18:13
 */
public class LittleGirlAndGame {
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

	public static void main(String[] args){
		char[] str = fs.nextString().toCharArray();
		int[] freq = new int[27];
		for(int i=0;i<str.length;i++){
			++freq[str[i] - 'a'];
		}

		int countOfOdd = 0;
		for(int i=0;i<26;i++){
			if(freq[i] % 2 != 0){
				++countOfOdd;
			}
		}

		if(countOfOdd == 1 || countOfOdd == 0){
			System.out.println("First");
		}else{
			--countOfOdd;
			if(countOfOdd % 2 == 0){
				System.out.println("First");
			}else{
				System.out.println("Second");
			}
		}
	}
}
