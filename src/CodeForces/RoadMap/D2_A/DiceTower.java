//package CodeForces.RoadMap.D2_A;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 04/04/2021, Sunday, 03:00
 */
public class DiceTower {
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
		fs.nextInt();
		boolean flag = false;
		for(int i=0;i<n;i++){
			int x = fs.nextInt();
			int y = fs.nextInt();
			if((x == 4 || x == 5) && (y == 4 || y == 5)){
				flag = true;
			}
		}
		System.out.println(flag?"YES" :"NO");
	}
}
