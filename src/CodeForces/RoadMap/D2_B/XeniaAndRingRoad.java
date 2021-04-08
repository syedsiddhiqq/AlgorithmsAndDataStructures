package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 08/04/2021, Thursday, 09:22
 */
public class XeniaAndRingRoad {
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
		int m = fs.nextInt();
		long[] arr = new long[m];
		long start = 1;
		long answer = 0;
		for(int i=0;i<m;i++){
			arr[i] = fs.nextLong();
			if(start<=arr[i]){
				answer+=arr[i] - start;
			}else{
				answer+= (n - start) + arr[i];
			}
			start = arr[i];
		}

		System.out.println(answer);
	}
}
