package CodeForces.RoadMap.D2_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * @author Syed Ali.
 * @createdAt 06/04/2021, Tuesday, 02:08
 */
public class MiraiStones {
	static class Fs{
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

		public long nextLong(){ return Long.parseLong(nextString()); }
	}

	static Fs fs = new Fs();

	public static void main(String[] args){
		PrintWriter out = new PrintWriter(System.out);
		int n = fs.nextInt();
		long[] sortedArr = new long[n+1];
		long[] prefixSum = new long[n+1];

		long sum = 0;
		for(int i=0;i<n;i++){
			long a = fs.nextLong();
			sortedArr[i] = a;
			sum+=a;
			prefixSum[i+1] = sum;
		}

		Arrays.sort(sortedArr);

		for(int i=0;i<n;i++){
			sortedArr[i+1] += sortedArr[i];
		}

		int m = fs.nextInt();
		for(int i=0;i<m;i++){
			int q = fs.nextInt();
			int l = fs.nextInt();
			int r = fs.nextInt();
			if(q == 1){
				out.println(prefixSum[r] - (l>0 ? prefixSum[l-1] : 0));
			}else{
				out.println(sortedArr[r] - (l > 0 ? sortedArr[l-1] : 0));
			}
		}
		out.close();
	}
}
