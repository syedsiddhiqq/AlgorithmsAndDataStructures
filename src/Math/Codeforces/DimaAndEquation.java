//package Math.Codeforces;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 31/03/2021, Wednesday, 16:49
 */
public class DimaAndEquation {
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

	static long sumOfDigit(long a){
		if(a < 0) return -1;
		long answer = 0;
		while(a>0){
			answer+=a % 10;
			a = a/10;
		}
		return answer;
	}

	static long pow(long a, long b){
		long answer = 1;
		for(int i=1;i<=b;i++){
			answer*=a;
		}
		return answer;
	}

	public static void main(String[] args) {
		long a,b,c;
		a = fs.nextLong();
		b = fs.nextLong();
		c = fs.nextLong();

		List<Long> solution = new ArrayList<>();

		for(long i=1;i <= 81;++i){
			long x = (b * pow(i,a)) + c;
			if(sumOfDigit(x) == i && x < pow(10,9)){
				solution.add(x);
			}
		}
		System.out.println(solution.size());
		for (Long aLong : solution) System.out.print(aLong + " ");
	}
}
