package CodeForces.contests.EducationalCodeforcesRound106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Syed Ali.
 * @createdAt 18/03/2021, Thursday, 21:29
 */
public class BinaryRemovals {

	static	class InputReader {
		private BufferedReader reader;
		private StringTokenizer stt;

		public InputReader() {
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

	private static void findsubsequences(String s,String ans) {
		if (s.length() == 0) {

			return;
		}
		findsubsequences(s.substring(1), ans + s.charAt(0));
		findsubsequences(s.substring(1), ans);
	}

	static boolean isSorted(char[] str)
	{
		// length of the string
		int n = str.length;
		int start = -1;

		// create a character array
		// of the length of the string
		char c[] = new char [101];

		// assign the string
		// to character array
		for (int i = 0; i < n; i++) {
			if(str[i]!='-'){
				c[++start] = str[i];
			}
		}

		// sort the character array
		Arrays.sort(c);

		// check if the character array
		// is equal to the string or not
		for (int i = 0,j=0; i < n && j< start; i++)
			if(str[i] != '-'){
				if (c[j] != str[i])
					return false;
				++j;
			}

		return true;
	}

	public static void main(String[] args) {

		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);

		int t = in.nextInt();

		while(t-->0){
			String s = in.nextString();
			char[] str = s.toCharArray();
			if(isSorted(str)){
				out.println("YES");
			}else{
//
			}

		}
		out.close();
	}
}



