//package CodeForces.RoadMap.D2_A;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 04/04/2021, Sunday, 20:09
 */
public class LaunchOfCollider {
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
		String s = fs.nextString();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = fs.nextInt();
		}

		int min = Integer.MAX_VALUE;
		for(int i=0;i<n-1;i++){
			if(s.charAt(i) == 'R' && s.charAt(i+1) == 'L'){
				min = Math.min(min,arr[i+1]-arr[i]);
			}
		}

		System.out.println(min == Integer.MAX_VALUE ? -1: min/2);
	}
}
