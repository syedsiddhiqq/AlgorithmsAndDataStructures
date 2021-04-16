package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 16/04/2021, Friday, 20:19
 */
public class TmtDocument {
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

	static class Count{
		int countOfM = 0;
		int countOfT = 0;

		Count(int countOfM,int countOfT){
			this.countOfM = countOfM;
			this.countOfT = countOfT;
		}
	}

	static void solve() {
		int n = fs.nextInt();
		char[] str = fs.nextString().toCharArray();
		int countOfT = 0;
		int countOfM = 0;

		int countOfT2 = 0;
		int countOfM2 = 0;

		Count[] before = new Count[n];
		Count[] after = new Count[n];

		for (int i = 0,j=n-1; i < str.length && j >=0; i++,j--) {
			if(str[i] == 'T'){
				countOfT++;
			}else{
				countOfM++;
			}

			if(str[j] == 'T'){
				countOfT2++;
			}else{
				countOfM2++;
			}
			before[i] = new Count(countOfM,countOfT);
			after[j] = new Count(countOfM2,countOfT2);
		}
		int m = n / 3;
		int t = n - n / 3;
		if (m == countOfM && t == countOfT) {
			for(int i=0;i<n;i++){
				if(str[i] == 'M'){
					if(before[i].countOfM > before[i].countOfT){
						System.out.println("NO");
						return;
					}

					if(after[i].countOfM > after[i].countOfT){
						System.out.println("NO");
						return;
					}
				}
			}
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	public static void main(String[] args) {
		int t = fs.nextInt();
		while (t-- > 0) {
			solve();
		}
	}
}
