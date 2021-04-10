package LeetCode.TopInterviewQuestions;

/**
 * @author Syed Ali.
 * @createdAt 10/04/2021, Saturday, 14:17
 */
public class UniquePaths {
	static class Solution {

		int row,col,count = 0;

		public void dfs(int[][] grid,int i,int j){
			if(i < 0 || i >=row || j < 0 || j >=col){
				return;
			}
			if(grid[i][j] == 1){
				++count;
			}

			//right
			dfs(grid,i,j+1);
			// down
			dfs(grid,i+1,j);
		}

		public int uniquePaths(int m, int n) {
			row = m;
			col = n;
			int[][] grid = new int[m][n];
			grid[m-1][n-1] = 1;
			dfs(grid,0,0);
			return count;
		}
	}

	/**
	 * using dp
	 * @param m
	 * @param n
	 * @return
	 */
	static int uniquePaths(int m, int n) {
		int[][] grid = new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(i == 0 || j == 0){
					grid[i][j] = 1;
				}else{
					grid[i][j] = grid[i][j-1] + grid[i-1][j];
				}
			}
		}
		return grid[m-1][n-1];
	}

	public static void main(String[] args) {
		new Solution().uniquePaths(3,7);
	}
}
