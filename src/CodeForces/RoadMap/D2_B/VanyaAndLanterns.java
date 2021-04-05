//package CodeForces.RoadMap.D2_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
/**
 * @author Syed Ali.
 * @createdAt 06/04/2021, Tuesday, 01:20
 */
public class VanyaAndLanterns {
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
		int n,l;
		n = fs.nextInt();
		l = fs.nextInt();

		Integer[] arr = new Integer[n];
		for(int i=0;i<n;i++){
			arr[i] = fs.nextInt();
		}
		Arrays.sort(arr,Collections.reverseOrder());
		double maxDist = -1;
		for(int i=1;i<n;i++){
			maxDist = Math.max(maxDist,arr[i-1] - arr[i]);
		}
//		BigDecimal answer = new BigDecimal(Math.max(maxDist/2, Math.max(l - arr[0],arr[n-1])));
//		System.out.println(answer.setScale(10, RoundingMode.HALF_UP));
		System.out.println(Math.max(maxDist/2, Math.max(l - arr[0],arr[n-1])));
	}
}
