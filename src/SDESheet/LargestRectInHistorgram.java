package SDESheet;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Syed Ali.
 * @createdAt 12/12/2021, Sunday, 15:34
 */
public class LargestRectInHistorgram {

	public static int largestRectangleArea(int[] heights) {
		if (heights.length == 0) return 0;

		int n = heights.length, maxRectangle = 0;

		Stack<Integer> st = new Stack<>();

		int[] pre = new int[n];
		int[] suff = new int[n];

		for (int i = 0; i < n; i++) {
			while (!st.isEmpty() && heights[st.peek()] > heights[i])
				st.pop();
			if (st.isEmpty()) {
				st.push(i);
				pre[i] = 0;
			} else {
				pre[i] = st.peek() + 1;
				st.push(i);
			}
		}

		st.clear();

		for (int i = n - 1; i >= 0; i--) {
			while (!st.isEmpty() && heights[st.peek()] > heights[i])
				st.pop();

			if (st.isEmpty()) {
				st.push(i);
				suff[i] = n - 1;
			} else {
				suff[i] = st.peek() - 1;
				st.push(i);
			}
		}

		for (int i = 0; i < n; i++) {
			maxRectangle = Math.max(maxRectangle, (suff[i] - pre[i] + 1 ) * heights[i]);
		}

		return maxRectangle;
	}

	public static void main(String[] args) {
		int[] heights = {2,4};
		Deque<Integer> q = new LinkedList<>();
		System.out.println(largestRectangleArea(heights));
	}
}
