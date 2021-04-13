//package CodeForces.RoadMap.D2_C1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * @author Syed Ali.
 * @createdAt 12/04/2021, Monday, 20:43
 */
public class YetAnotherCardDeck {
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
		int n, q;
		n = fs.nextInt();
		q = fs.nextInt();
		Deque<Integer> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			queue.add(fs.nextInt());
		}

		for (int i = 0; i < q; i++) {
			int temp = fs.nextInt();
			int start = 0;
			for (Integer ele : queue) {
				++start;
				if (ele == temp) {
					break;
				}

			}

			queue.remove(temp);
			queue.addFirst(temp);
			System.out.print(start + " ");
		}
	}
}
