package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 17/04/2021, Saturday, 02:48
 */
public class NastyaAndDoor {
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

		static class Peak{
			int index;
		}

		static void solve(){
			int n,k;
			n = fs.nextInt();
			k = fs.nextInt();
			long[] arr = new long[n];
			int[] peakIndices = new int[n];
			int count = 0;
			for(int i=0;i<n;i++){
				arr[i] = fs.nextLong();
			}

			for(int i=0;i<n;i++){
				if( i > 0 && i < n-1){
					if(arr[i] > arr[i-1] && arr[i] > arr[i+1]){
						++count;
					}
				}
				peakIndices[i] = count;
			}

			long max = Integer.MIN_VALUE;
			int leftIndex = 0;
			for(int i=0;i<n;i++){
				if(i + k-1 < n){
					int peaks = peakIndices[i + k - 2] - peakIndices[i];
					if(max < peaks){
						max = peaks;
						leftIndex = i;
					}
				}
			}

			System.out.println(max+1 + " " + (leftIndex+1));
		}

		public static void main(String[] args){
		    int t = fs.nextInt();
		    while(t-->0){
		        solve();
		    }
		}
}
