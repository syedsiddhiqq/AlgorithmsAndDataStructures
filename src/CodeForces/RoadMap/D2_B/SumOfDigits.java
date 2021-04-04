//package CodeForces.RoadMap.D2_B;
import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 05/04/2021, Monday, 01:26
 */
public class SumOfDigits {
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

	static long sumOfDigits(long n){
		long sum = 0;
		while(n > 0){
			sum += n % 10;
			n = n/10;
		}
		return sum;
	}

	public static void main(String[] args){
		char[] n = fs.nextString().toCharArray();
		long sum=0;
		int answer = n.length > 1 ? 1 : 0;
		for(int i=n.length-1;i>=0;i--){
			sum+=Integer.parseInt(n[i]+"");
		}
		while(sum >= 10){
			++answer;
			sum = sumOfDigits(sum);
		}
		System.out.println(answer);
	}
}
