package LeetCode.Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Syed Ali.
 * @createdAt 23/11/2021, Tuesday, 19:00
 */
public class MinArrowsShot {
	public static int findMinArrowShots(int[][] points) {
		int n = points.length;
		if(n == 1) return 1;
		Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

		int maxEnd = points[0][1];
		int answer = 1;
		for(int i=1;i<n;i++){
			if(points[i][0] <= maxEnd){
				answer++;
				maxEnd = points[i][1];
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		// [[-2147483646,-2147483645],[2147483646,2147483647]]
		int[][] intervals = {{-2147483646,-2147483645},{2147483646,2147483647}};
		findMinArrowShots(intervals);
	}
}
