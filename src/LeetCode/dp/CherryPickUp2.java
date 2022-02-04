package LeetCode.dp;

/**
 * @author Syed Ali.
 * @createdAt 30/12/2021, Thursday, 10:23
 */
public class CherryPickUp2 {
	public int cherryPickup(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		Integer[][][] dp = new Integer[m][n][n];
		int ans = dfs(grid, m, n, 0, 0, n - 1, dp);
		for(Integer[][] arr : dp){
			for(int i=0;i<arr.length;i++){
				for(int j=0;j<arr[0].length;j++){
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("-------------------------------------------");
		}
		return ans;
	}
	int dfs(int[][] grid, int m, int n, int r, int c1, int c2, Integer[][][] dp) {
		if (r == m) return 0; // Reach to bottom row
		if (dp[r][c1][c2] != null) {
			System.out.println(r + " "+ c1 + " " + c2);
			return dp[r][c1][c2];
		};
		int ans = 0;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				int nc1 = c1 + i, nc2 = c2 + j;
				if (nc1 >= 0 && nc1 < n && nc2 >= 0 && nc2 < n) {
					int tempResult = dfs(grid, m, n, r + 1, nc1, nc2, dp);
					ans = Math.max(ans, tempResult);
				}
			}
		}
		int cherries = c1 == c2 ? grid[r][c1] : grid[r][c1] + grid[r][c2];
		return dp[r][c1][c2] = ans + cherries;
	}

	public static void main(String[] args) {
		int[][] grid = {{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
		CherryPickUp2 c = new CherryPickUp2();
		System.out.println(c.cherryPickup(grid));
	}
}
