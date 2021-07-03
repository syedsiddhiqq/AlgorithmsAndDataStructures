//package CodeForces.RoadMap.diff1200;

import java.util.*;

/**
 * @author Syed Ali.
 * @createdAt 29/06/2021, Tuesday, 13:47
 */
public class SameParitySummands {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 0; t < T; t++) {
			int N = in.nextInt();
			int K = in.nextInt();
			boolean odd = (N >= K) && ((N - (K - 1)) % 2 == 1);
			boolean even = (N >= 2 * K) && (N - 2 * (K - 1)) % 2 == 0;
			if (odd || even) {
				System.out.println("YES");
				StringBuilder output = new StringBuilder();
				for (int k = 1; k < K; k++) {
					output.append(odd ? '1' : '2').append(' ');
				}
				output.append(odd ? (N - (K - 1)) : (N - 2 * (K - 1)));
				System.out.println(output);
			} else {
				System.out.println("NO");
			}
		}
	}
}
