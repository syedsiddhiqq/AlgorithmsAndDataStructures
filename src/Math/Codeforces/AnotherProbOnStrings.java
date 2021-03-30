package Math.Codeforces;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 30/03/2021, Tuesday, 01:28
 */
public class AnotherProbOnStrings {

	static Scanner in  = new Scanner(System.in);


	static void solve(){
		char[] c;
		int[] d;
		int k = in.nextInt();
		c = in.next().toCharArray();
		d = new int[c.length+10];
		int cur = 0;
		long ans = 0;
		d[0] = 1;
		for(int i = 0; i < c.length; i++){
			cur += c[i] - '0';
			if(cur >= k) ans += d[cur-k];
			d[cur]++;
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		solve();
	}
}
