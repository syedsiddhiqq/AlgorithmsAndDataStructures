//package CodeForces.RoadMap.D2_A;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 02/04/2021, Friday, 01:03
 */
public class AntonAndDanik {
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
		char[] str = fs.nextString().toCharArray();
		int anton = 0, danik = 0;
		for(int i=0;i<n;i++){
			if(str[i] == 'A') ++anton;
			else ++danik;
		}
		if(anton == danik) System.out.println("Friendship");
		else if(danik > anton) System.out.println("Danik");
		else System.out.println("Anton");
	}


}
