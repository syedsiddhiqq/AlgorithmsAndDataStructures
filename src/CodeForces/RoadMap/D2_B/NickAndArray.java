package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 08/04/2021, Thursday, 13:22
 */
public class NickAndArray {
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

		public long nextLong() {
			return Long.parseLong(nextString());
		}
	}

	static Fs fs = new Fs();

	static int op( int a){
		return (-(a) - 1);
	}

	public static void main(String[] args) {
		int n = fs.nextInt();
		int minPositive = Integer.MAX_VALUE, minPositiveIndex = -1;
		int maxNegative = Integer.MIN_VALUE, maxNegativeIndex = -1;

		int counOfNeg = 0, countOfPos = 0;

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = fs.nextInt();

			if (arr[i] < 0) {
				++counOfNeg;
				if (maxNegative < arr[i]) {
					maxNegative = arr[i];
					maxNegativeIndex = i;
				}
			} else {
				++countOfPos;
				if (minPositive > arr[i] && arr[i] != 0) {
					minPositive = arr[i];
					minPositiveIndex = i;
				}
			}
		}

		if (n == 1) {
			if (arr[0] < 0) {
				arr[0] = -(arr[0]) - 1;
			}
			System.out.println(arr[0]);
		}else if(counOfNeg % 2 == 0 && countOfPos % 2 == 0){
			for(int i=0;i<n;i++){
				if(arr[i] > -1){
					arr[i] = op(arr[i]);
				}
				System.out.print(arr[i] + " ");
			}
		}else if(countOfPos % 2 == 0){
			if(arr[minPositiveIndex] < op(arr[maxNegativeIndex])){
				arr[minPositiveIndex] = op(arr[minPositiveIndex]);
			}else{
				arr[maxNegativeIndex] = op(arr[maxNegativeIndex]);
			}
			for(int i=0;i<n;i++){
				if(arr[i] > -1){
					arr[i] = op(arr[i]);
				}
				System.out.print(arr[i] + " ");
			}
		}else if(countOfPos > 1){
			arr[minPositiveIndex] = op(arr[minPositiveIndex]);
			arr[maxNegativeIndex] = op(arr[maxNegativeIndex]);
			for(int i=0;i<n;i++){
				if(arr[i] > -1){
					arr[i] = op(arr[i]);
				}
				System.out.print(arr[i] + " ");
			}
		}else{
			for(int i=0;i<n;i++){
				System.out.print(arr[i] + " ");
			}
		}
	}
}
