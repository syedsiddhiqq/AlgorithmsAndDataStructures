package LeetCode.Amazon.Medium;

import java.util.Arrays;

/**
 * @author Syed Ali.
 * @createdAt 21/10/2021, Thursday, 17:36
 */
public class ZigZag {
	public static String convert(String s, int numRows) {
		char[] str = s.toCharArray();
		int length = str.length;
		char[][] grid = new char[numRows][length];

		for (int i = 0; i < numRows; i++) Arrays.fill(grid[i], '-');
		int start = 0, row = numRows - 1, col = 0;
		boolean down = false;
		for (int i = 0; i < numRows; i++) grid[i][0] = str[start++];
		while (start < length) {
			int temp = numRows - 1;
			if (down) {
				down = false;
				while (temp-- > 0 && start < length) {
					System.out.println(row + " " + col);
					grid[++row][col] = str[start++];
				}
			} else {
				down = true;
				while (temp-- > 0 && start < length) {
					System.out.println(row + " " + col);
					grid[--row][++col] = str[start++];
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < length; j++) {
				if (grid[i][j] != '-') {
					sb.append(grid[i][j]);
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 4));
	}
}
