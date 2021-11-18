package CodeForces.RoadMap.Diff1300;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 28/09/2021, Tuesday, 20:12
 */
public class StringSolitaire {
	private static Scanner s = new Scanner(System.in);

	private static void solve(){
		char[] str = s.next().toCharArray();

		int[] count = new int[3];
		for (char c : str) {
			++count[c - 'A'];
		}


		if(count[0] + count[2] == count[1]){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	}

	public static void main(String[] args) {
		int t =s.nextInt();
		while(t-->0){
			solve();
		}
	}
}
