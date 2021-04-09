package LeetCode.TopInterviewQuestions;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Syed Ali.
 * @createdAt 09/04/2021, Friday, 03:50
 */
public class KthLargest {
	static class Solution {
		public int findKthLargest(int[] nums, int k) {
			Queue<Integer> pq = new PriorityQueue<>(nums.length, Collections.reverseOrder());
			for(int i=0;i<nums.length;i++){
				pq.add(nums[i]);
			}
			int answer = 0;
			while(k-->0){
				answer = pq.poll();
			}
			return answer;
		}
	}
}
