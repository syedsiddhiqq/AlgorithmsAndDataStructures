//package CodeForces.RoadMap.D2_A;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 02/04/2021, Friday, 03:08
 */
public class Presents {
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
		int[] arr = new int[n+1];
		int[] friends = new int[n+1];
		for(int i=1;i<=n;i++){
			arr[i] = fs.nextInt();
			friends[arr[i]] = i;
		}

		for(int i=1;i<=n;i++)
			System.out.print(friends[i] + " ");
	}
}
