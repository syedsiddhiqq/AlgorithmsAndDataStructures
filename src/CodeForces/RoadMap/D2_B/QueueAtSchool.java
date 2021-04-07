package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 08/04/2021, Thursday, 02:29
 */
public class QueueAtSchool {
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
		int n = fs.nextInt();
		int t = fs.nextInt();
		StringBuilder str = new StringBuilder();
		str.append(fs.nextString());

		for(int i=0;i<t;i++){
			for(int j=0;j<n-1;++j){
				if(str.charAt(j) == 'B' && str.charAt(j+1) == 'G'){
					str.setCharAt(j,'G');
					str.setCharAt(j+1,'B');
					++j;
				}
			}
		}

		System.out.println(str);
	}
}
