package GFG;

import java.util.Arrays;

/**
 * @author Syed Ali.
 * @createdAt 03/12/2021, Friday, 07:29
 */
public class NMeetings {
	public static int maxMeetings(int start[], int end[], int n){
		int[][] meetings = new int[n][2];

		for(int i=0;i<n;i++){
			meetings[i][0] = start[i];
			meetings[i][1] = end[i];
		}

		Arrays.sort(meetings, (a, b)->{
			return a[1] - b[1];
		});
		int endTime = meetings[0][1];
		int meeting = 1;
		for(int i=1;i<n;i++){
			if(meetings[i][0] > endTime){
				endTime = meetings[i][1];
				meeting++;
			}
		}
		return meeting;
	}

	public static void main(String[] args) {
		int[] start = {1,3,0,5,8,5};
		int[] end = {2,4,6,7,9,9};
		maxMeetings(start,end,6);
	}
}
