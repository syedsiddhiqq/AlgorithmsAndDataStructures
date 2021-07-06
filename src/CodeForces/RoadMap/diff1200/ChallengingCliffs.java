package CodeForces.RoadMap.diff1200;

import java.util.*;
/**
 * @author Syed Ali.
 * @createdAt 03/07/2021, Saturday, 12:12
 */
public class ChallengingCliffs {
	/**
	 * Not my solution... Since my solution is getting tle.. idk why..
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t=0; t<T; t++) {
			int N = in.nextInt();
			Integer[] H = new Integer[N];
			for (int n=0; n<N; n++) {
				H[n] = in.nextInt();
			}
			Arrays.sort(H);
			int shift = 0;
			int diff = H[N-1]-H[0];
			for (int n=1; n<N; n++) {
				int d = H[n] - H[n-1];
				if (d < diff) {
					diff = d;
					shift = n;
				}
			}
			StringBuilder output = new StringBuilder();
			for (int n=0; n<N; n++) {
				output.append(H[(n+shift)%N]).append(' ');
			}
			System.out.println(output);
		}
	}
}
