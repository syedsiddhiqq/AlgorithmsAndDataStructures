package codechef.MarchLunchTime;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 27/03/2021, Saturday, 21:53
 */
public class DinnerByCandleLight {
	static Scanner scanner = new Scanner(System.in);

	static void solve(){
		int a,y,x;
		a = scanner.nextInt();
		y = scanner.nextInt();
		x = scanner.nextInt();

		if(a == 0){
			System.out.println(1);
		}else{
			if(a >= y){
				System.out.println(x*y);
			}else{System.out.println(1 + (a*x));
			}
		}
	}

	public static void main(String[] args) {
		int t = scanner.nextInt();
		while(t-->0){
			solve();
		}
	}
}
