package CodeForces.RoadMap.D2_C1;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 16/04/2021, Friday, 23:30
 */
public class Queue545D {
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
		long[] arr = new long[n];
		for(int i=0;i<n;i++){
			arr[i] = fs.nextLong();
		}

		Arrays.sort(arr);
		int answer= 0;
		long waitTime = 0;
		for(int i=0;i<n;i++){
			if(waitTime <= arr[i]){
				++answer;
				waitTime+=arr[i];
			}
		}
		System.out.println(answer);
	}
}
