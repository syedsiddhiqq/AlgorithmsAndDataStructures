package LeetCode.Hard;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Syed Ali.
 * @createdAt 06/12/2021, Monday, 19:24
 */
public class RatInAMaze {
	public static ArrayList<String> findPath(int[][] m, int n) {
		boolean[][] visited = new boolean[n][n];
		for(int i=0;i<n;i++){
			Arrays.fill(visited[i],false);
		}
		ArrayList<String> result = new ArrayList<>();
		solve(m,"",visited,0,0,n,result);
		return result;
	}

	private static void solve(int[][] m,String s,boolean[][] visited, int row, int col, int n,ArrayList<String> result){
		if(row < 0 || col < 0 || row >= n || col >= n || visited[row][col] || m[row][col] == 0) return;

		if(row == n-1 && col == n-1){
			result.add(s);
			return;
		}else{
			visited[row][col] = true;

			solve(m,s+"D",visited,row+1,col,n,result);
			solve(m,s+"L",visited,row,col-1,n,result);
			solve(m,s+"R",visited,row,col+1,n,result);
			solve(m,s+"U",visited,row-1,col,n,result);

			visited[row][col] = false;
		}
	}
}
