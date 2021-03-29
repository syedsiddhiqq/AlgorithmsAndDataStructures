package CodeForces.contests.codecraftcrdiv2711;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author Syed Ali.
 * @createdAt 29/03/2021, Monday, 20:04
 */
public class B {
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

	}
	static Fs fs = new Fs();

	static void solve(){
		int n = fs.nextInt();
		int w = fs.nextInt();
		int[] arr = new int[n];
		Queue<Integer> pq = new PriorityQueue<>(n, Comparator.reverseOrder());
		for(int i=0;i<n;i++){
			arr[i] = fs.nextInt();
			pq.add(arr[i]);
		}

		int sum = 0;
		int answer = 1;
		while(!pq.isEmpty()){
			int temp = pq.peek();
			if(sum + temp > w){
				sum = 0;
				answer++;
			}else{
				sum += temp;
				pq.poll();
			}
		}
		System.out.println(answer);
	}

	public static void main(String[] args) {
		int t = fs.nextInt();
		while(t-->0){
			solve();
		}
	}
}