package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 05/04/2021, Monday, 00:55
 */
public class CaisaAndPylons {
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
		for(int i=0;i<n;i++){
			arr[i] = fs.nextInt();
		}

		int dollars = arr[0];
		int energy = 0;
		for(int i=1;i<n;i++){
			if(arr[i-1]>arr[i]){
				energy+=arr[i-1] - arr[i];
			}else{
				if(arr[i-1]+energy>=arr[i]){
					energy = arr[i-1]+energy - arr[i];
				}else{
					dollars+=arr[i] - (arr[i-1]+energy);
					energy = 0;
				}
			}
		}
		System.out.println(dollars);
	}
}
