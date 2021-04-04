package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 05/04/2021, Monday, 02:50
 */
public class EffectiveApproach {
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
		int[] arr = new int[n];
		int[] indexArr = new int[n+1];

		for(int i=0;i<n;i++){
			arr[i] = fs.nextInt();
			indexArr[arr[i]] = i;
		}

		long vasya = 0;
		long petya = 0;
		int q = fs.nextInt();
		for(int i=0;i<q;i++){
			int x = fs.nextInt();
			vasya+= indexArr[x]+1;
			petya+= n - indexArr[x];
		}
		System.out.println(vasya+" "+petya);
	}
}
