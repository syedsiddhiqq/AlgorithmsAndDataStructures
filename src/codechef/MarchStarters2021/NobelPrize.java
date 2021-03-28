package codechef.MarchStarters2021;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Syed Ali.
 * @createdAt 28/03/2021, Sunday, 16:09
 */
public class NobelPrize {

	static Scanner scanner = new Scanner(System.in);

	static void solve(){
		int n,m;
		n = scanner.nextInt();
		m = scanner.nextInt();

		Set<Integer> set = new HashSet<>();
		for(int i=0;i<n;i++){
			int temp = scanner.nextInt();
			set.add(temp);
		}

		System.out.println(set.size() == m ? "No" : "Yes");
	}
	public static void main(String[] args) {

		int t = scanner.nextInt();

		while(t-- > 0){
			solve();
		}
	}
}
