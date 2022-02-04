package LeetCode.Hard;

/**
 * @author Syed Ali.
 * @createdAt 06/12/2021, Monday, 15:38
 */
public class SudokuSolver {
	public static void solveSudoku(char[][] board) {
		solve(board, 0, 0);
	}

	private static boolean solve(char[][] board, int row, int col) {
		for(int i=row;i<9;i++,col = 0){
			for(int j=col;j<9;j++){
				if(board[i][j] == '.'){
					for(char ch='1';ch<='9';ch++){
						if(validate(board,i,j,ch)){
							board[i][j] = ch;
							if(solve(board, row, j+1)) return true;
							board[i][j] = '.';
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	private static boolean validate(char[][] board, int row, int col, char value) {

		// check if value is already there in the row
		for (int i = 0; i < 9; i++) {
			if (board[row][i] == value) {
				return false;
			}
		}


		// check if value is already there in the column
		for (int i = 0; i < 9; i++) {
			if (board[i][col] == value) {
				return false;
			}
		}


		// check if that value is present in that 3x3 matrix.
		row = row == 0 ? 0 : (row / 3) * 3;
		col = col == 0 ? 0 : (col / 3) * 3;

		for (int i = row; i < row + 3; i++) {
			for (int j = col; j < col + 3; j++) {
				if (board[i][j] == value) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		char[][] board = new char[9][9];
		board[0] = new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'};
		board[1] = new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'};
		board[2] = new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'};
		board[3] = new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'};
		board[4] = new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'};
		board[5] = new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'};
		board[6] = new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'};
		board[7] = new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'};
		board[8] = new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'};
		solveSudoku(board);
		System.out.println();
	}
}
