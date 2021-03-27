package codechef.MarchLunchTime;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 27/03/2021, Saturday, 20:15
 */
public class TurnIt {

	static Scanner scanner = new Scanner(System.in);

	static void solve(){
		int U,V,A,S;
		U = scanner.nextInt();
		V = scanner.nextInt();
		A = scanner.nextInt();
		S = scanner.nextInt();

		if(U == V || U < V){
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}

	public static void main(String[] args) {
		int t = scanner.nextInt();
		while(t-- > 0){
			solve();
		}
	}
}
