package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 04/04/2021, Sunday, 21:36
 */
public class ReorderTheArray {
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
		List<Integer> asc = new ArrayList<>();
		for(int i=0;i<n;i++){
			arr[i] = fs.nextInt();
			asc.add(arr[i]);
		}
		Collections.sort(asc);

		for(int i=0;i<n;i++){
			int index = asc.indexOf(arr[i]);
			arr[i] = asc.get(n);
		}
	}
}
