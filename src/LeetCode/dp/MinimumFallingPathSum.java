package LeetCode.dp;

/**
 * @author Syed Ali.
 * @createdAt 30/12/2021, Thursday, 14:44
 */
public class MinimumFallingPathSum {
	private int row,col;
	public int minFallingPathSum(int[][] matrix) {
		row = matrix.length;
		col = matrix[0].length;

		int ans = Integer.MAX_VALUE;
		for(int i=0;i<col;i++){
			ans = Math.min(ans,findMinSum(matrix,0,i));
		}
		return ans;
	}

	private int findMinSum(int[][] grid,int r, int c){
		if(r == row) return 0;
		int ans = Integer.MAX_VALUE;
		for(int i=-1;i<=1;i++){
			int nextCol = c + i;
			if( nextCol >=0 && nextCol < col)
				ans = Math.min(ans, findMinSum(grid,r+1,c+i));
		}
		return ans + grid[r][c];
	}

	public static void main(String[] args) {
		MinimumFallingPathSum m = new MinimumFallingPathSum();
		int[][] grid = {{2,1,3},{6,5,4},{7,8,9}};
		m.minFallingPathSum(grid);
	}
}
