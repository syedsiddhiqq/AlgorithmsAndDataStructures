package codechef.MarchLunchTime;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 27/03/2021, Saturday, 21:35
 */
public class Racing {
	static Scanner scanner = new Scanner(System.in);

	static void solve(){
		int x,r,m;
		x = scanner.nextInt() / 60;
		r = scanner.nextInt() ;
		m = scanner.nextInt() ;


		while(r > 0){
			--x;
			--r;
			if(m >= 1){
				++x;
			}
			--m;
		}
	}

	public static void main(String[] args) {
		int t = scanner.nextInt();
		while(t-->0){
			solve();
		}
	}
}
