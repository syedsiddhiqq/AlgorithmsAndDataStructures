package CodeForces;

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
 * @createdAt 18/03/2021, Thursday, 00:40
 * https://codeforces.com/problemset/problem/352/B
 */
public class JeffAndPeriods352B {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		int n = in.nextInt();

		int[] lastValueArray = new int[100001];
		Arrays.fill(lastValueArray,-1);
		int[] differenceValueArray = new int[100001];
		Arrays.fill(differenceValueArray,-1);

		for(int i=0;i<n;i++){
			int x = in.nextInt();
			if(lastValueArray[x] == -1){
				lastValueArray[x] = i;
			}else{
				if(differenceValueArray[x] == -2) continue;
				if(differenceValueArray[x] == -1){
					differenceValueArray[x] = i - lastValueArray[x];
				}else{
					int currentDifference = i - lastValueArray[x];
					if(currentDifference != differenceValueArray[x]){
						differenceValueArray[x] = -2;
					}
				}
				lastValueArray[x] = i;
			}
		}

		int count = 0;
		for(int i=0;i<=100000;++i){
			if(lastValueArray[i] != -1){
				if(differenceValueArray[i] != -2){
					++count;
				}
			}
		}
		out.println(count);

		for(int i=0;i<=100000;++i){
			if(lastValueArray[i] != -1){
				if(differenceValueArray[i] != -2){
					out.println(i + " " + ( differenceValueArray[i] == -1 ? 0 : differenceValueArray[i]));
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
