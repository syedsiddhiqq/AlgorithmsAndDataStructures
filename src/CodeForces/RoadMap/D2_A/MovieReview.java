//package CodeForces.RoadMap.D2_A;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 12/04/2021, Monday, 20:06
 */
public class MovieReview {
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
		    int firstServer = 0,secondServer = 0;
		    for(int i=0;i<n;i++){
		    	int temp = fs.nextInt();
		    	if(temp == 1){
		    		firstServer++;
				}else if(temp == 2){
		    		secondServer++;
				}else{
		    		firstServer++;
				}
			}
			System.out.println(firstServer);
		}

		public static void main(String[] args){
		    int t = fs.nextInt();
		    while(t-->0){
		        solve();
		    }
		}
}
