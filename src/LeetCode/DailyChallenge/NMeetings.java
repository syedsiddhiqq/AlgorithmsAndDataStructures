package LeetCode.DailyChallenge;

import java.util.Arrays;

/**
 * @author Syed Ali.
 * @createdAt 07/01/2022, Friday, 16:44
 */
public class NMeetings {

	public static int maxMeetings(int start[], int end[], int n) {
		int[][] meetings = new int[n][2];

		for (int i = 0; i < n; i++) {
			meetings[i] = new int[]{start[i], end[i]};
		}

		Arrays.sort(meetings, (a, b) -> {
			if (a[1] < b[1]) return -1;

			if (a[1] == b[1]) {
				if (a[0] >= b[0]) {
					return -1;
				} else {
					return 1;
				}
			}

			return 1;
		});

		int ans = 1,prev = meetings[0][1];
		for(int i=1;i<n;i++){
			if(meetings[i][0] > prev){
				ans++;
				prev = meetings[i][1];
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		int[] start = {1,3,0,5,8,5};
		int[] end = {2,4,6,7,9,9};

		System.out.println(maxMeetings(start, end,6 ));
	}
}
