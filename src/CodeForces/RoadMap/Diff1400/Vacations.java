package CodeForces.RoadMap.Diff1400;

import java.util.*;

/**
 * @author Syed Ali.
 * @createdAt 10/05/2021, Monday, 15:27
 */
public class Vacations {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int n = s.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		int rest = 0;
		for (int i = 1; i < n; i++) {
			if (arr[i] == 1 && arr[i - 1] == 1) {
				arr[i] = 0;
			} else if (arr[i] == 2 && arr[i - 1] == 2) {
				arr[i] = 0;
			} else if (arr[i] == 3) {
				if (arr[i - 1] == 1) {
					arr[i] = 2;
				} else if (arr[i - 1] == 2) {
					arr[i] = 1;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0)
				rest++;
		}

		System.out.println(rest);
	}
}
