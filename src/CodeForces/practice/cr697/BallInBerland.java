package CodeForces.practice.cr697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author Syed Ali.
 * @createdAt 24/03/2021, Wednesday, 11:05
 */
public class BallInBerland {
	static class Fs {
		private BufferedReader bufferedReader;
		private StringTokenizer stt;


		public Fs() {
			this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		}

		public String nextLine() {
			try {
				return bufferedReader.readLine();
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

		public long nextLong() {
			return Long.parseLong(nextString());
		}
	}

	static Fs fs = new Fs();

	static void solve(){
		int a = fs.nextInt();
		int b = fs.nextInt();
		int k = fs.nextInt();
		int[] arrA = new int[k];
		int[] arrB = new int[k];
		Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
		for(int i=0;i<k;i++){
			arrA[i] = fs.nextInt();
		}

		for(int i=0;i<k;i++){
			arrB[i] = fs.nextInt();
		}

		// Creating the adjacency List.
		for(int i=0;i<k;i++){
			for(int j=0;j<k;j++){
				if(adjacencyList.containsKey(arrA[i])){
					if(!adjacencyList.get(arrA[i]).contains(arrB[j])){
						adjacencyList.get(arrA[i]).add(arrB[j]);
					}
				}else{
					List<Integer> arr = new ArrayList<>();
					arr.add(arrB[i]);
					adjacencyList.put(arrA[i],arr);
				}
			}
		}


	}

	public static void main(String[] args) {
		int t = fs.nextInt();

		while(t-->0){
			solve();
		}
	}
}
