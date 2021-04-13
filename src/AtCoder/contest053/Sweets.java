//package AtCoder.contest053;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 11/04/2021, Sunday, 17:30
 */
public class Sweets {
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

		static void solve(){
		    int n = fs.nextInt();

			System.out.println(--n);
		}

		public static void main(String[] args){
		   solve();
		}
}
