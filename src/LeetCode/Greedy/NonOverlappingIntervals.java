package LeetCode.Greedy;

import java.util.Arrays;

/**
 * @author Syed Ali.
 * @createdAt 23/11/2021, Tuesday, 15:10
 */
public class NonOverlappingIntervals {
	public static int eraseOverlapIntervals(int[][] intervals) {
		int n = intervals.length;
		Arrays.sort(intervals, (o1, o2) -> {
			return o1[1] - o2[1];
		});

		int answer = 1;
		int maxEnd = intervals[0][1];
		for(int i=1;i<intervals.length;i++){
			int start = intervals[i][0],end = intervals[i][1];
			if(start >= maxEnd){
				answer++;
				maxEnd = end;
			}
		}
		return n - answer;
	}

	public static void main(String[] args) {
		String s = "[[-52,31],[-73,-26],[82,97],[-65,-11],[-62,-49],[95,99],[58,95],[-31,49],[66,98],[-63,2],[30,47],[-40,-26]]";
		int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
		eraseOverlapIntervals(intervals);
	}
}
