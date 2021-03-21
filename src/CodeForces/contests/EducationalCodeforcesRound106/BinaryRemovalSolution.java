package CodeForces.contests.EducationalCodeforcesRound106;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Syed Ali.
 * @createdAt 21/03/2021, Sunday, 17:29
 */
public class BinaryRemovalSolution {

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
		FastScanner fastScanner = new FastScanner();
		int t = fastScanner.nextInt();

		while(t-->0){
			boolean flag = false;
			String s = fastScanner.nextString();
			for(int i=0;i<s.length()-1;i++){
				if(s.charAt(i) == '1' && s.charAt(i+1) == '1'){
					for(int j=i+2; j<s.length();j++){
						if(s.charAt(j) == '0' && j+1 < s.length() && s.charAt(j+1) == '0'){
							flag = true;
							break;
						}
					}
				}
				if(flag) break;
			}
			System.out.println(flag ? "NO" :"YES");
		}
	}
}


