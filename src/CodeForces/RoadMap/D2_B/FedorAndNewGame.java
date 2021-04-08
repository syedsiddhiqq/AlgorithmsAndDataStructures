package CodeForces.RoadMap.D2_B;


import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 08/04/2021, Thursday, 09:52
 */
public class FedorAndNewGame {
	static class Fs {
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

		public long nextLong() {
			return Long.parseLong(nextString());
		}
	}

	static Fs fs = new Fs();

	public static void main(String[] args) {
		int n,m,k;
		n = fs.nextInt();
		m = fs.nextInt();
		k = fs.nextInt();

		int[] arr = new int[m+2];
		for(int i=1;i<=m+1;i++){
			arr[i] = fs.nextInt();
		}

		int friends = 0;
		for(int i=1;i<=m;i++){
			if(Integer.bitCount(arr[i] ^ arr[m+1]) <= k){
				friends++;
			}
		}
		System.out.println(friends);
	}
}
