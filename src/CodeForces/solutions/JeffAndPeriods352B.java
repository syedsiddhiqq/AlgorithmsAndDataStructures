package CodeForces.solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JeffAndPeriods352B {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int n = in.nextInt();
		int[] last = new int[100001];
		Arrays.fill(last, -1);
		int[] delta = new int[100001];
		Arrays.fill(delta, -1);
		for (int i = 0; i < n; ++i) {
			int x = in.nextInt();
			if (last[x] == -1) {
				last[x] = i;
			} else {
				if (delta[x] == -2) continue;
				if (delta[x] == -1) {
					delta[x] = i - last[x];
				} else {
					int curD = i - last[x];
					if (delta[x] != curD) {
						delta[x] = -2;
					}
				}
				last[x] = i;
			}
		}
		int am = 0;
		for (int i = 0; i <= 100000; ++i) {
			if (last[i] != -1) {
				if (delta[i] != -2) {
					++am;
				}
			}
		}
		out.println(am);
		for (int i = 0; i <= 100000; ++i) {
			if (last[i] != -1) {
				if (delta[i] != -2) {
					out.println(i + " " + (delta[i] == -1 ? 0 : delta[i]));
				}
			}
		}
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

