//package CodeForces.RoadMap.Diff1300;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 28/09/2021, Tuesday, 20:26
 */
public class ShiftingSort {
	private static Scanner s = new Scanner(System.in);

	private static void solve() {
		int n = s.nextInt();
		List<Integer> arr = new LinkedList<>();
		List<Integer> copyOf = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add(s.nextInt());
			copyOf.add(arr.get(i));
		}

		Collections.sort(copyOf);

		int i = 0,moves = 0;
		StringBuilder result = new StringBuilder();
		while(i < n){
			int temp = copyOf.get(i);

			for (int j = i; j < n; j++) {
				if(arr.get(j) == temp && j == i) {
					++i;
					break;
				}
				if (arr.get(j) == temp && j != i) {
					++moves;
					result.append(i + 1).append(" ").append(j + 1).append(" ").append(j - i).append("\n");
					shift(arr,i,j,j-i);
					++i;
					break;
				}
			}
		}
		System.out.println(moves);
		System.out.println(result.toString());
	}

	private static void shift(List<Integer> arr, int l, int r, int d) {
		while (d-- > 0) {
			int t = arr.get(l);
			arr.remove(l);
			arr.add(r,t);
		}
	}

	public static void main(String[] args) {
		int t = s.nextInt();
		while (t-- > 0) {
			solve();
		}
	}
}
