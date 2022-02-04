package LeetCode.dp;

/**
 * @author Syed Ali.
 * @createdAt 30/12/2021, Thursday, 19:57
 */
public class DungeonGame {
	public int calculateMinimumHP(int[][] dungeon) {
		int row = dungeon.length,col = dungeon[0].length;
		int[][] dp = new int[row][col];

		dp[0][0] = dungeon[0][0] >= 0 ? 0 : (- 1 * dungeon[0][0]);

		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(i == 0 && j == 0) continue;
				if(i-1 >= 0 && j-1 >= 0){
					if(dp[i-1][j] < dp[i][j-1]){
						dungeon[i][j] += dungeon[i-1][j];
						dp[i][j] = dp[i-1][j];
					}else{
						dungeon[i][j] += dungeon[i][j-1];
						dp[i][j] = dp[i][j-1];
					}
				}else if(i - 1 >= 0){
					dungeon[i][j] += dungeon[i-1][j];
					dp[i][j] = dp[i-1][j];
				}else{
					dungeon[i][j] += dungeon[i][j-1];
					dp[i][j] = dp[i][j-1];
				}
				int value = dungeon[i][j] >= 0 ? 0 : (-1 * dungeon[i][j]);
				dp[i][j] = value == 0 ? dp[i][j] : Math.max(value,dp[i][j]);
			}
		}
		return dp[row-1][col-1] + 1;
	}

	public static void main(String[] args) {
		DungeonGame d = new DungeonGame();
		int[][] grid = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
		System.out.println(d.calculateMinimumHP(grid));
	}
}
