package CodeForces.contests.contestdiv31619;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 20/12/2021, Monday, 19:59
 */
public class A {
	private static Scanner s = new Scanner(System.in);

	private static void solve(){
		String str = s.next();
		if(str.length() % 2 != 0){
			System.out.println("NO");
		}else{
			if(str.substring(0,str.length()/2).equals(str.substring(str.length()/2))){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}

	public static void main(String[] args) {
		int t = s.nextInt();
		while(t-->0){
			solve();
		}
	}
}
