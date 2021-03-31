//package Math.Codeforces;
import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 01/04/2021, Thursday, 00:06
 */
public class MafiaBsearchApproach {
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

	static boolean checkIfPossible(int k,int[] arr){
		// there should be atleast k supervisors.
		// each person can supervise k - arr[i] games
 		int supervisors = 0;
		for(int i=0;i<arr.length;i++){
			supervisors += k - arr[i];
			if(supervisors >=k){
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int n = fs.nextInt();
		int[] arr = new int[n];
		int sum  = 0;
		for(int i=0;i<n;i++){
			arr[i] = fs.nextInt();
			sum+=arr[i];
		}

		// Max rounds possible == sum of all array elements.
		// perform bsearch to find optimal solution
		int low = 0;
		int high = sum;
		int answer = sum;
		while(low<=high){
			int mid = (low+high)/2;
			if(checkIfPossible(mid,arr)){
				answer = mid;
				high = mid - 1;
			}else{
				low = mid+1;
			}
		}
		System.out.println(answer);
	}
}
