//package CodeForces.RoadMap.diff1200;

import java.util.*;

/**
 * @author Syed Ali.
 * @createdAt 06/07/2021, Tuesday, 22:44
 */
public class BoatsCompetition {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] a = new int[101];
			for (int i = 0; i < n; i++)
				a[sc.nextInt()]++;
			if (n == 1)
				System.out.println(0);
			else if (n <= 3)
				System.out.println(1);
			else {
				int m = 0, max = 0;
				for (int i = 2; i <= 2 * n; i++) {
					for (int j = 1; j <= i; j++) {
						m += Math.min(a[j], a[i - j]);
					}
					max = Math.max(m, max);
					m = 0;
				}
				System.out.println(max / 2);
			}
		}
	}
}
