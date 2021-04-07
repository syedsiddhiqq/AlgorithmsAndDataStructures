package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 07/04/2021, Wednesday, 02:20
 */
public class MahmoudAndTriangle {
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

	static boolean checkForDegenerate(long a,long b, long c){
		return a + b > c && b + c > a && a + c > b;
	}

	public static void main(String[] args){
		int n = fs.nextInt();
		Long[] arr = new Long[n];
		for(int i=0;i<n;i++){
			arr[i] = fs.nextLong();
		}
		Arrays.sort(arr,Collections.reverseOrder());

		boolean flag = false;
		for(int i=0;i<n-2;i++){
			if(checkForDegenerate(arr[i],arr[i+1],arr[i+2])){
				flag = true;
			}
		}
		System.out.println(flag ? "YES" : "NO");
	}
}
