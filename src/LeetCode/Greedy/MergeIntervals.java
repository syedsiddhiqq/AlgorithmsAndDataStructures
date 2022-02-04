package LeetCode.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Syed Ali.
 * @createdAt 23/11/2021, Tuesday, 22:44
 */
public class MergeIntervals {
	public static Integer[][] merge(int[][] intervals) {
		List<Integer[]> result = new ArrayList<>();


		Arrays.sort(intervals, (a, b) -> {
			return a[0] - b[0];
		});


		int minStart = intervals[0][0];
		int minEnd = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] <= minEnd) {
				result.add(new Integer[]{minStart, intervals[i][1]});
				minEnd = intervals[i][1];
			}
		}
		Integer[][] resultArr = new Integer[result.size()][2];
		for (int i = 0; i < result.size(); i++) {
			resultArr[i] = result.get(i);
		}
		return resultArr;
	}

	public static void main(String[] args) {
		int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
		merge(intervals);
	}
}
