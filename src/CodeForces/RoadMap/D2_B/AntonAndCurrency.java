package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 09/04/2021, Friday, 16:10
 */
public class AntonAndCurrency {
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
		StringBuilder res = new StringBuilder();
		char[] str = fs.nextString().toCharArray();
		char a = str[str.length - 1];
		int prev = -1;
		for(int i=0;i<str.length - 1;i++){
			int temp  = Integer.parseInt(str[i]+"");
			if(temp % 2 == 0){
				if(Integer.parseInt(a+"") > temp){
					char t = str[str.length - 1];
					str[str.length - 1] = str[i];
					str[i] = t;
					break;
				}
				prev = i;
			}
		}

		int temp = Integer.parseInt(str[str.length - 1]+"") % 2;
		if( temp!= 0 && prev == -1){
			System.out.println("-1");
		}else if(temp != 0) {
			char t = str[str.length - 1];
			str[str.length - 1] = str[prev];
			str[prev] = t;
			System.out.println(res.append(str));
		}else{
			System.out.println(res.append(str));
		}
	}
}
