//package CodeForces.RoadMap.D2_A;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 04/04/2021, Sunday, 02:08
 */
public class GoodNumber {
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

		static void solve(){
			int n = fs.nextInt();
			int k = fs.nextInt();

			boolean flag = false;
			int answer = 0;
			for(int i=0;i<n;i++){
				String s = fs.nextString();
				for(int j=0;j<=k;j++){
					if(!s.contains(j+"")){
						flag = true;
						break;
					}
				}
				if(!flag){
					++answer;
				}else{
					flag = false;
				}
			}
			System.out.println(answer);
		}

		public static void main(String[] args){
			solve();
		}
}
