package AtCoder.contest053;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 10/04/2021, Saturday, 17:48
 */
public class TakingTheMiddle {
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
		long[] arr = new long[2 * n];
		long sum = 0;
		int length = 2 * n;
		Map<Long,Integer> freq = new HashMap<>();
		Queue<Long> pq = new PriorityQueue<>(2 * n, Collections.reverseOrder());
		for (int i = 0; i < 2 * n; i++) {
			arr[i] = fs.nextLong();
			sum += arr[i];
			pq.add(arr[i]);
			freq.put(arr[i],freq.getOrDefault(arr[i],0)+1);
		}
		long answer = 0;
		while (!pq.isEmpty()) {
			long value = pq.poll();
			if(freq.containsKey(value)){
				freq.put(value,freq.get(value) - 1);
			}
			--length;
			answer += value;
			sum -= value;
			int index = (int) sum / length;
			long valueChosenByOpp = arr[index-1];
			sum -= valueChosenByOpp;
			pq.remove(valueChosenByOpp);
			--length;
		}
		System.out.println(answer);
	}
}
