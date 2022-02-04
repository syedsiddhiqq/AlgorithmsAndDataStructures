package LeetCode.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Syed Ali.
 * @createdAt 05/12/2021, Sunday, 18:16
 */
public class NQueens {
	List<List<String>> resultList = new ArrayList<>();

	public  List<List<String>> solveNQueens(int n) {
		char[][] board = new char[n][n];
		for(int i=0;i<n;i++){
			Arrays.fill(board[i],'.');
		}
		nQueens(board,0,0,n,0);
		return resultList;
	}

	private  void nQueens(char[][] board,int row, int col,int n,int queens){
		if(queens == n){
			List<String> temp = new ArrayList<>();
			for(int i=0;i<n;i++){
				temp.add(new String(board[i]));
			}
			resultList.add(temp);
			return;
		}else{
			for(int j=col;j<n;j++){
				board[row][j] = 'Q';
				if(validate(board,n,row,j)){
					nQueens(board,row+1,0,n,queens+1);
				}
				board[row][j] = '.';
			}
		}
	}

	private  boolean validate(char[][] board,int n,int i,int j){

		// check up
		int row = i - 1;
		while(row >=0){
			if(board[row][j] == 'Q'){
				return false;
			}
			row--;
		}

		// down
		row = i+1;
		while(row < n){
			if(board[row][j] == 'Q'){
				return false;
			}
			row++;
		}

		// left
		int col = j - 1;
		while(col >= 0){
			if(board[i][col] == 'Q'){
				return false;
			}
			col--;
		}

		// right;
		col = j + 1;
		while(col < n){
			if(board[i][col] == 'Q'){
				return false;
			}
			col ++;
		}

		// upper left diagonal
		row = i - 1;
		col = j - 1;
		while(row >=0 && col>=0){
			if(board[row][col] == 'Q'){
				return false;
			}
			row --;
			col -- ;
		}

		// upper right diagonal
		row = i - 1;
		col = j + 1;
		while(row >=0 && col < n){
			if(board[row][col] == 'Q'){
				return false;
			}
			row--;
			col++;
		}

		// lower left diag
		row  = i+1;
		col = j-1;
		while( row < n && col >=0 ){
			if(board[row][col] == 'Q'){
				return false;
			}
			row ++;
			col--;
		}

		// lower right diag
		row = i + 1;
		col = j + 1;
		while(row < n && col < n){
			if(board[row][col] == 'Q'){
				return false;
			}
			row++;
			col++;
		}
		return true;
	}

	private  void print(char[][] board,int n){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}
