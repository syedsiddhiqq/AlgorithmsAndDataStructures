//package CodeForces.practice.implementation;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 01/04/2021, Thursday, 19:40
 */
public class WinnerSolution {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt(), score, ans = (int) -1e9;
		Map<String, Integer> mp = new HashMap<>();
		String[] s = new String[n];
		int sum[] = new int[n];
		for (int i = 0; i < n; i++) {
			s[i] = cin.next();
			sum[i] = cin.nextInt();
			if (mp.containsKey(s[i])) {
				sum[i] += mp.get(s[i]);
				mp.put(s[i], sum[i]);
			} else mp.put(s[i], sum[i]);
		}
		ans = Collections.max(mp.values());
		for (int i = 0; i < n; i++) {
			if (ans == mp.get(s[i]) && sum[i] >= ans) {
				System.out.println(s[i]);
				break;
			}
		}
	}
}
