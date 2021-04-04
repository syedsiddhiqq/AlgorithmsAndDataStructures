//package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 05/04/2021, Monday, 03:26
 */
public class EasterEggs {
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
		int n = fs.nextInt();
		String s = "ROYGBIV";
		StringBuilder res = new StringBuilder();
		res.append("ROYG");
		for(int i=0;i< (n - 7)/4;i++){
			res.append("ROYG");
		}
		res.append("ROYG",0,(n-7)%4);
		res.append("BIV");
		System.out.println(res);
	}
}
