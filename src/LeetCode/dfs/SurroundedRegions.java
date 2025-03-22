package LeetCode.dfs;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 05-03-2023, Sunday, 06:41
 * https://leetcode.com/problems/surrounded-regions/
 */
public class SurroundedRegions {
    private void markOne(char[][] board, int i, int j){
        int row = board.length, col = board[0].length;
        if(i < 0 || i >= row || j < 0 || j >= col || board[i][j] == 'X' || board[i][j] == '1' ) return;
        board[i][j] = '1';
        markOne(board, i, j - 1);
        markOne(board, i - 1, j);
        markOne(board, i, j+1);
        markOne(board, i+1,j);
    }

    public void solve(char[][] board) {
        int row = board.length, col = board[0].length;
        for(int j=0;j<col;j++){
            if(board[0][j] == 'O') markOne(board, 0, j);
            if(board[row - 1][j] == 'O') markOne(board, row - 1, j);
        }
        for(int i = 0;i<row;i++){
            if(board[i][0] == 'O') markOne(board, i, 0);
            if(board[i][col - 1] == 'O') markOne(board, i, col - 1);
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j] == '1') board[i][j] = 'O';
                else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'O', 'O'}, {'O','O'}};
        SurroundedRegions surroundedRegions = new SurroundedRegions();
        surroundedRegions.solve(board);
    }
}
