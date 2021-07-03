package CodeForces.RoadMap.diff1200;

import java.util.*;

/**
 * @author Syed Ali.
 * @createdAt 02/07/2021, Friday, 21:02
 */
public class StableGroups {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long k = sc.nextLong();
		long x = sc.nextLong();
		Long a[] = new Long[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextLong();
		}
		Arrays.sort(a);
		ArrayList<Long> al = new ArrayList<>();
		long diff;
		for (int i = 0; i < n - 1; i++) {
			diff = a[i + 1] - a[i];
			if (diff > x) {
				long div = (diff - 1) / x;
				al.add(div);
			}
		}
		Collections.sort(al);
		long ans = al.size() + 1;
		for (int i = 0; i < al.size(); i++) {
			if (k >= al.get(i)) {
				k -= al.get(i);
				ans -= 1;
			} else {
				break;
			}
		}
		System.out.println(ans);
	}
}
