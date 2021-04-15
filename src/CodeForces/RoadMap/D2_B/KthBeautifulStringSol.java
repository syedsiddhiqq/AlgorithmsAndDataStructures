//package CodeForces.RoadMap.D2_B;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 15/04/2021, Thursday, 20:11
 */
public class KthBeautifulStringSol {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		ArrayList<Integer> t = new ArrayList();
		t.add(1);
		while(t.get(t.size()-1)<2e9) {
			t.add(t.get(t.size()-1)+t.size()+1);
		}
		while(tc-->0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			char[] ans = new char[n];
			Arrays.fill(ans, 'a');
			int idx = Collections.binarySearch(t, k);
			if(idx<0) idx = -(idx+1);
			int r = t.get(idx)-k+1;
			ans[n-2-idx] = ans[n-2-idx+r] = 'b';
			System.out.println(ans);
		}
	}
}
