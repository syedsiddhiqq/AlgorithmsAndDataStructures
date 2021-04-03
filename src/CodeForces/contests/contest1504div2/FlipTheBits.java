package CodeForces.contests.contest1504div2;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 03/04/2021, Saturday, 20:41
 */
public class FlipTheBits {
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
			String a = fs.nextString();
			String b = fs.nextString();

			char[] str1 = a.toCharArray();
			char[] str2 = b.toCharArray();

			for(int i=0;i<str1.length;i++){

			}

			if(a.equals(b)){
				System.out.println("YES");
			}else{

			}

		}

		public static void main(String[] args){
		    int t = fs.nextInt();
		    while(t-->0){
		        solve();
		    }
		}
}
