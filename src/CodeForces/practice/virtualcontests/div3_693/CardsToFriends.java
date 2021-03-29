//package CodeForces.practice.virtualcontests.div3_693;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Syed Ali.
 * @createdAt 29/03/2021, Monday, 16:27
 */
public class CardsToFriends {

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
		int w,h,n;
		w = fs.nextInt();
		h = fs.nextInt();
		n = fs.nextInt();

		if(n == 1){
			System.out.println("YES");
		}else{
			int totalSheets = 1;
			boolean flag = false;
			while(w > 1 && w%2 == 0){
				w = w/2;
				totalSheets *=2;
				if(n <= totalSheets){
					flag = true;
					break;
				}
			}

			while(h > 1 && h%2 == 0 && !flag){
				h = h/2;
				totalSheets *=2;
				if(n <= totalSheets){
					flag = true;
					break;
				}
			}

			System.out.println(flag ? "YES":"NO");
		}
	}

	public static void main(String[] args) {
		int t = fs.nextInt();
		while(t-->0){
			solve();
		}
	}

}
