//package CodeForces.practice.implementation;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 01/04/2021, Thursday, 17:30
 */
public class LevelStatistics {
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
			int size = fs.nextInt();
			int p = 0;
			int c = 0;
			boolean flag = true;
			for(int i = 0;i<size;i++)
			{
				int x = fs.nextInt();
				int y = fs.nextInt();
				if(x<p||y<c||y-c>x-p)
					flag = false;
				p = x;
				c = y;
			}
			System.out.println(flag?"YES":"NO");
		}

		public static void main(String[] args){
		    int t = fs.nextInt();
		    while(t-->0){
		        solve();
		    }
		}
}
