package CodeForces.practice.virtualcontests.div3_710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author Syed Ali.
 * @createdAt 29/03/2021, Monday, 00:48
 */
public class PartialReplacementB {
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

	static void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = fs.nextInt();
		int k = fs.nextInt();

		String s = fs.nextLine();

		char[] str = s.toCharArray();
		boolean initiallyPlaced = false;
		int prevIndex = 0;
		int distance = 0;
		int answer = 0;
		for(int i=0;i<str.length;i++){
			if(str[i] == '*'  && !initiallyPlaced){
				str[i] = 'x';
				initiallyPlaced = true;
				prevIndex = -1;
				distance = 0;
				answer++;
			}
			++distance;

			if(distance > k && initiallyPlaced){
				if(str[i] == '.'){
					str[prevIndex] = 'x';
					answer++;
				}else if(str[i] == '*'){
					prevIndex = i;
					if(str[prevIndex] == 'x'){
						str[i] = 'x';
						answer++;
					}else{
						str[prevIndex] = 'x';
						answer++;
					}
				}
			}

			if(str[i] == '*'){
				prevIndex = i;
			}

		}

		if(str[prevIndex] != 'x'){
			answer++;
		}
		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		int t = fs.nextInt();
		while(t-->0){
			solve();
		}
	}
}
