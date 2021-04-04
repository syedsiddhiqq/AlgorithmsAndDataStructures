//package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 04/04/2021, Sunday, 23:48
 */
public class BearAndFindingCriminals {
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
		int a = fs.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = fs.nextInt();
		}

		int answer = (arr[a - 1] == 1 ? 1 : 0);
		int left = a-2,right = a;
		while (left >= 0 || right < n) {
			if (left >= 0 && right < n && arr[left] == 1 && arr[right] == 1) {
				answer += 2;
			}
			if (left >= 0 && right >= n && arr[left] == 1) {
				++answer;
			}

			if (right < n && left < 0 && arr[right] == 1) {
				++answer;
			}
			left--;
			right++;
		}
		System.out.println(answer);
	}
}
