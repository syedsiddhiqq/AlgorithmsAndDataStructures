//package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 06/04/2021, Tuesday, 04:39
 */
public class SortTheArray {
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
		int n = fs.nextInt();
		int[] arr = new int[n + 1];

		arr[0] = -1;
		boolean flag = false;
		int startIndex = -1;
		int endIndex = -1;
		for (int i = 1; i <= n; i++) {
			arr[i] = fs.nextInt();
			if (arr[i] < arr[i - 1] && !flag) {
				flag = true;
				startIndex = i - 1;
			}

			if (flag && arr[i] > arr[i - 1]) {
				endIndex = i - 1;
				flag = false;
			}
		}
		if(startIndex == -1){
			startIndex = 1;
			endIndex = 1;
		}
		if(endIndex == -1){
			endIndex = n;
		}

		Arrays.sort(arr, startIndex, endIndex + 1);
		flag = false;
		for (int i = 1; i <= n; i++) {
			if (arr[i] < arr[i - 1]) {
				flag = true;
				break;
			}
		}
		System.out.println(flag ? "no" : "yes\n" + startIndex + " " + (endIndex));
	}
}
