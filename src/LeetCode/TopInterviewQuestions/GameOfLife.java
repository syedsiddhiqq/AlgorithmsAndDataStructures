package LeetCode.TopInterviewQuestions;

/**
 * @author Syed Ali.
 * @createdAt 10/04/2021, Saturday, 03:17
 */
public class GameOfLife {
	static class Solution {

		boolean valid(int i, int j, int row, int col) {
			if (i < 0 || i >= row || j < 0 || j >= col) {
				return false;
			}
			return true;
		}

		int livesOrDies(int count) {
			if (count < 2) {
				return 0;
			} else if (count == 2 || count == 3) {
				return 1;
			} else {
				return 0;
			}
		}

		public void gameOfLife(int[][] board) {
			int row = board.length;
			int col = board[0].length;
			int[][] result = new int[row][col];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					int count = 0;
					// upper left
					if (valid(i - 1, j - 1, row, col) && board[i - 1][j - 1] == 1) {
						++count;
					}

					// up
					if (valid(i - 1, j, row, col) && board[i - 1][j] == 1) {
						++count;
					}

					//upper right
					if (valid(i - 1, j + 1, row, col) && board[i - 1][j + 1] == 1) {
						++count;
					}

					// left
					if (valid(i, j - 1, row, col) && board[i][j - 1] == 1) {
						++count;
					}

					// right
					if (valid(i, j + 1, row, col) && board[i][j + 1] == 1) {
						++count;
					}

					// lower left
					if (valid(i + 1, j - 1, row, col) && board[i + 1][j - 1] == 1) {
						++count;
					}

					// down
					if (valid(i + 1, j, row, col) && board[i + 1][j] == 1) {
						++count;
					}

					//lower right
					if (valid(i + 1, j + 1, row, col) && board[i + 1][j + 1] == 1) {
						++count;
					}

					if (board[i][j] == 1) {
						result[i][j] = livesOrDies(count);
					} else {
						result[i][j] = count == 3 ? 1 : 0;
					}
				}
			}

			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					board[i][j] = result[i][j];
				}
			}
		}
	}
}
