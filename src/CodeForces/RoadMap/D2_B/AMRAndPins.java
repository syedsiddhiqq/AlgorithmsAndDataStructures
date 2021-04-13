//package CodeForces.RoadMap.D2_B;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 13/04/2021, Tuesday, 23:15
 */
public class AMRAndPins {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int xp = sc.nextInt();
		int yp = sc.nextInt();

		double d = Math.sqrt(1.0*(xp-x)*(xp-x) + 1.0*(yp - y)*(yp - y));
		int n = (int)(Math.ceil(d/(2*r)));
		System.out.println(n);
	}
}
