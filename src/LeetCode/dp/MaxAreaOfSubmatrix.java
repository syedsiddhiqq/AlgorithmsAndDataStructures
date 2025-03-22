package LeetCode.dp;

import java.util.*;

public class MaxAreaOfSubmatrix {
    public static int maximalAreaOfSubMatrixOfAll1(int[][] mat, int n, int m) {
        int ans = 0;
        int[] heights = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) heights[j] = 0;
                else heights[j] += mat[i][j];
            }
            ans = Math.max(ans, histogramOptimized(heights));
        }
        return ans;
    }

    private static int histogram(int[] heights) {
        int n = heights.length;
        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();
        int[] leftNge = new int[n];
        int[] rightNge = new int[n];
        for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--) {
            while (!left.isEmpty() && heights[left.peek()] >= heights[i]) {
                left.pop();
            }
            if (left.isEmpty()) {
                leftNge[i] = 0;
            } else {
                leftNge[i] = left.peek() + 1;
            }
            left.push(i);

            while (!right.isEmpty() && heights[right.peek()] >= heights[j]) {
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

    private static int histogramOptimized(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int max = 0;
        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || heights[st.peek()] >= heights[i])) {
                // Whenever we pop what does that mean, we found an element which is lesser than the element
                // in the top of the stack ?
                // That is nothing but right Next smaller element for the element that we are deleting.
                // After deletion Left smaller element will now become of the stack
                // Bit tricky if you are confused watch video from Striver.
                int height = heights[st.pop()];
                int width;
                if (st.isEmpty()) {
                    width = i;
                } else {
                    width = i - st.peek() - 1;
                }
                int area = width * height;
                max = Math.max(max, area);
            }
            st.push(i);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 0, 1, 1},
                {1, 0, 1, 1},
                {0, 1, 0, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 1}
        };
        System.out.println(maximalAreaOfSubMatrixOfAll1(mat, 5, 4));
    }
}
