package codechef.starters14;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 29/09/2021, Wednesday, 20:00
 */
public class RcbAndPlayoffs {
	private static Scanner s = new Scanner(System.in);

	private static void solve(){
		int x,y,z;
		x = s.nextInt();
		y = s.nextInt();
		z = s.nextInt();


		if((x + (2 * z)) >= y){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	}

	public static void main(String[] args) {
		int t =  s.nextInt();
		while(t-->0){
			solve();
		}
	}
}
