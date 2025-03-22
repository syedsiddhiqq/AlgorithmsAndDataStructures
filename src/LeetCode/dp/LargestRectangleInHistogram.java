package LeetCode.dp;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();
        int[] leftNge = new int[n];
        int[] rightNge = new int[n];
        for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--) {
            while (!left.isEmpty() && heights[left.peek()] > heights[i]) {
                left.pop();
            }
            if (left.isEmpty()) {
                leftNge[i] = 0;
            } else {
                leftNge[i] = left.peek() + 1;
            }
            left.push(i);

            while (!right.isEmpty() && heights[right.peek()] > heights[j]) {
                right.pop();
            }
            if (right.isEmpty()) {
                rightNge[j] = n - 1;
            } else {
                rightNge[j] = right.peek() - 1;
            }
            right.push(j);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int width = rightNge[i] - leftNge[i] + 1;
            max = Math.max(max, width * heights[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }
}
