//package CodeForces.practice.virtualcontests.div3_693;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author Syed Ali.
 * @createdAt 29/03/2021, Monday, 16:53
 */
public class EvenOddGame {
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

		public Long nextLong(){
			return Long.parseLong(nextString());
		}

	}

	static Fs fs = new Fs();

	static void solve(){
		int n = fs.nextInt();
		long[] arr = new long[n];
		Queue<Long> evenArray = new PriorityQueue<>(n,Collections.reverseOrder());
		Queue<Long> oddArray = new PriorityQueue<>(n,Collections.reverseOrder());
		for(int i=0;i<n;i++){
			arr[i] = fs.nextInt();
			if(arr[i] % 2 == 0){
				evenArray.add(arr[i]);
			}else{
				oddArray.add(arr[i]);
			}
		}

		long evenSum = 0;
		long oddSum = 0;
		for(int i=0;i<n;i++){

			// alice turn to play optimally.
			if(!oddArray.isEmpty() && !evenArray.isEmpty()){
				if(evenArray.peek() > oddArray.peek()){
					evenSum+=evenArray.poll();
				}else{
					oddArray.poll();
				}
			}else if(!evenArray.isEmpty()){
				evenSum+=evenArray.poll();
			}else if(!oddArray.isEmpty()){
				oddArray.poll();
			}

			// bob turn to play optimally
			if(!oddArray.isEmpty() && !evenArray.isEmpty()){
				if(oddArray.peek() > evenArray.peek()){
					oddSum+=oddArray.poll();
				}else{
					evenArray.poll();
				}
			}else if(!oddArray.isEmpty()){
				oddSum+=oddArray.poll();
			}else if(!evenArray.isEmpty()){
				evenArray.poll();
			}

			if(evenArray.isEmpty() && oddArray.isEmpty())
				break;
		}

		if(evenSum == oddSum){
			System.out.println("Tie");
		}else if(evenSum < oddSum){
			System.out.println("Bob");
		}else{
			System.out.println("Alice");
		}
	}

	public static void main(String[] args) {
		int t = fs.nextInt();
		while(t-->0){
			solve();
		}
	}
}
