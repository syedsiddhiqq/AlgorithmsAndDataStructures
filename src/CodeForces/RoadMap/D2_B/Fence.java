//package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 06/04/2021, Tuesday, 03:22
 */
public class Fence {
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
		int n, k;
		n = fs.nextInt();
		k = fs.nextInt();

		int[] prefixSum = new int[n + 1];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += fs.nextInt();
			prefixSum[i + 1] = sum;
		}

		int min = prefixSum[k];
		int minIndex = k;
		for (int i = k+1; i <= n; i++) {
			if (i - k >= 1) {
				int val = prefixSum[i] - prefixSum[i - k];
				if(min > val){
					min = val;
					minIndex = i;
				}
			}
		}
		System.out.println(minIndex-k + 1);
	}
}
