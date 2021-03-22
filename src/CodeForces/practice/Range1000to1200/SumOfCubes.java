package CodeForces.practice.Range1000to1200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author Syed Ali.
 * @createdAt 22/03/2021, Monday, 21:14
 */
public class SumOfCubes {
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

		public long nextLong() { return Long.parseLong(nextString());}

	}

	public static void main(String[] args) {
		Fs fs = new Fs();
		int t = fs.nextInt();

		Map<Long, Long> dataMap = new HashMap<>();
		Double n = Math.pow(10,6);
		for(long i=1;i<n.longValue();i++){
			dataMap.put(i,i * i * i);
		}

		while(t-->0){
			Long x = fs.nextLong();
			boolean flag = false;
			for(long i= 1;i<x;i++){
				if(dataMap.containsValue( x - dataMap.get(i))){
					flag = true;
				}
			}

			System.out.println(flag?"YES":"NO");
		}
	}
}
