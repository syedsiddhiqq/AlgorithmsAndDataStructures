package Common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Syed Ali.
 * @createdAt 22/03/2021, Monday, 07:39
 */

public class Fs {
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

}
