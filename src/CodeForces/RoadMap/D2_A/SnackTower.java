//package CodeForces.RoadMap.D2_A;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 02/04/2021, Friday, 12:39
 */
public class SnackTower {
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
		Queue<Integer> pq = new PriorityQueue<>(n,Collections.reverseOrder());
		int expectedSize = n;
		for(int i=0;i<n;i++){
			int temp = fs.nextInt();
			if(temp == expectedSize){
				System.out.print(expectedSize-- + " ");
				while(!pq.isEmpty() && pq.peek() == expectedSize){
					System.out.print(pq.poll()+" ");
					expectedSize--;
				}
				System.out.println();
			}else{
				pq.add(temp);
				System.out.println();
			}
		}
	}
}
