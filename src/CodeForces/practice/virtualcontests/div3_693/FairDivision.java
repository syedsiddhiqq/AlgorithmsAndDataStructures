//package CodeForces.practice.virtualcontests.div3_693;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Syed Ali.
 * @createdAt 29/03/2021, Monday, 16:36
 */
public class FairDivision {
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
		int[] arr = new int[n];
		int sum = 0;
		int[] freq = new int[3];
		for(int i=0;i<n;i++){
			arr[i] = fs.nextInt();
			++freq[arr[i]];
			sum+=arr[i];
		}

		if(sum % 2 != 0 || n % 2 != 0){
			System.out.println("NO");
		}else{
			System.out.println((freq[1] == freq[2] || freq[1] == n || freq[2] == n) ? "YES" : "NO");
		}
	}
	public static void main(String[] args) {
		int t = fs.nextInt();
		while(t-->0){
			solve();
		}
	}

}
