//package NumberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Syed Ali.
 * @createdAt 21/03/2021, Sunday, 18:37
 */
public class BachGoldProblem {
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
		int n = in.nextInt();

		if(n % 2 == 0){
			out.println(n/2);
			for(int i=0;i<n/2;i++) {
				out.print("2 ");
			}
		}else{
			out.println(n/2);
			for(int i=0;i<n/2 - 1;i++) {
				out.print("2 ");
			}
			out.print("3");
		}

		out.close();
	}
}
