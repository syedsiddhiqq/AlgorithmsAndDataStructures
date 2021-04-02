//package CodeForces.RoadMap.D2_A;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 02/04/2021, Friday, 03:19
 */
public class LineLandMail {
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

	static int addOrSub(int a, int b){
		if((a < 0 && b < 0) || (a > 0 && b > 0)){
			return Math.abs(a-b);
		}else{
			return Math.abs(a)+Math.abs(b);
		}
	}

	public static void main(String[] args){
		int n = fs.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = fs.nextInt();
		}

		for(int i=0;i<n;i++){
			// check for min from both left and right
			int left = i-1,right = i+1;
			int leftValue = Integer.MAX_VALUE,rightValue = Integer.MAX_VALUE;
			if(left >=0){
				leftValue = addOrSub(arr[left],arr[i]);
			}
			if(right<n){
				rightValue = addOrSub(arr[i],arr[right]);
			}
			System.out.print(Math.min(leftValue,rightValue) + " ");
			leftValue = addOrSub(arr[i],arr[0]);
			rightValue = addOrSub(arr[i],arr[n-1]);
			System.out.println(Math.max(leftValue,rightValue));
		}
	}
}
