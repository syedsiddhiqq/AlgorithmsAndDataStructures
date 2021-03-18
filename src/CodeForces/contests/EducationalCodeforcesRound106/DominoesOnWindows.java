//package CodeForces.contests.EducationalCodeforcesRound106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Syed Ali.
 * @createdAt 18/03/2021, Thursday, 20:44
 * https://codeforces.com/contest/1499/problem/0
 */
public class DominoesOnWindows {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);

		int t = in.nextInt();

		while(t-->0){
			int n,k1,k2,w,b;
			n = in.nextInt();
			k1 = in.nextInt();
			k2 = in.nextInt();
			w = in.nextInt();
			b = in.nextInt();
			int totalCells = 2 * n;
			int whiteCells = k1+k2;
			int blackCells = totalCells - whiteCells;
			if(whiteCells >= 2 * w && blackCells >= 2 * b){
				out.println("YES");
			}else{
				out.println("NO");
			}
		}
		out.close();
	}
}



class InputReader {
	private BufferedReader reader;
	private StringTokenizer stt;

	public InputReader(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream));
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