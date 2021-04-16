package CodeForces.RoadMap.D2_C1;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 16/04/2021, Friday, 18:39
 */
public class AliceBoBAndCandies {
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
		    Deque<Integer> q = new LinkedList<>();
		    for(int i=0;i<n;i++){
		    	q.add(fs.nextInt());
			}

		    int moves = 1;
		    int alice = 0;
		    int bob = 0;
		    alice = q.removeFirst();
		    while(!q.isEmpty()){
		    	int sum = 0;

			}
		}

		public static void main(String[] args){
		    int t = fs.nextInt();
		    while(t-->0){
		        solve();
		    }
		}
}
