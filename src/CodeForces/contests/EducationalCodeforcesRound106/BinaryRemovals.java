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
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);

		int t = in.nextInt();

		while(t-->0){
			String s = in.nextString();
			char[] str = s.toCharArray();
			char[] sortedStr = s.toCharArray();
			Arrays.sort(sortedStr);
			int[] indexOfZero = new int[101];
			int[] indexOfOnes = new int[101];
			Arrays.fill(indexOfOnes,-1);
			Arrays.fill(indexOfZero,-1);
			if(isSorted(str)){
				out.println("YES");
			}else{
//				for(int i=0;i<str.length;i++) newArr[i] = str[i];

				for(int i=0;i<str.length;i++){
					char[] newArr = new char[str.length];
					for(int k=0;k<str.length;k++) newArr[k] = str[k];
					newArr[i] = '-';
					if(str[i] == '1'){
						for(int j=i+1;j<str.length;j++){

						}
					}
				}

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