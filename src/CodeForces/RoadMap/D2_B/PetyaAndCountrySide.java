//package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 04/04/2021, Sunday, 23:02
 */
public class PetyaAndCountrySide {
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
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = fs.nextInt();
		}

		int maxSection = -1;
		int sectionSize = 1;
		boolean flag = false;
		for(int i=1;i<n;i++){
			if(arr[i-1] <= arr[i] && !flag){
				sectionSize++;
			}else if(arr[i-1] >= arr[i] && sectionSize > 0){
				flag = true;
				sectionSize++;
			}else{
				maxSection = Math.max(maxSection,sectionSize);
				sectionSize = 2;
				for(int j=i-2;j>=0 && arr[j] == arr[i-1];j--){
					sectionSize++;
				}
				flag = false;
			}
		}
		maxSection = Math.max(sectionSize,maxSection);
		System.out.println(maxSection == -1 ? 0 : maxSection);
	}
}
