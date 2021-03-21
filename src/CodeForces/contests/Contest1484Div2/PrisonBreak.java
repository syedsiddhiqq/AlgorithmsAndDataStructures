//package CodeForces.contests.Contest1484Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Syed Ali.
 * @createdAt 21/03/2021, Sunday, 18:59
 */
public class PrisonBreak {
	static class FastScanner {
		private BufferedReader reader;
		private StringTokenizer stt;

		public FastScanner() {
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
	}

	public static void main(String[] args) {
		FastScanner in = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int  t = in.nextInt();
		while(t-->0){
			int a = in.nextInt();
			int b = in.nextInt();

			out.println(a*b);
		}
		out.close();
	}
}
