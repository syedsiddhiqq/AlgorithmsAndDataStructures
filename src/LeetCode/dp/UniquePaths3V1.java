package LeetCode.dp;

/**
 * @author Syed Ali.
 * @createdAt 29/12/2021, Wednesday, 22:56
 */
public class UniquePaths3V1 {
	int count = 0;

	int[][] visited;

	public int uniquePathsIII(int[][] grid) {
		int row = grid.length,col = grid[0].length;
		int total = 0,startRow = 0,startCol = 0;
		visited = new int[row][col];
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(grid[i][j] == 0){
					total++;
				}else if(grid[i][j] == 1){
					startRow = i;
					startCol = j;
				}
			}
		}
		findPaths(grid,-1,total,startRow,startCol,row,col);
		return count;
	}

	public void findPaths(int[][] grid,int zeroes,int total,int i,int j,int row, int col){
		// if(i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == -1) return;
		if(visited[i][j] != 0) return;
		if(grid[i][j] == 2 && zeroes >= total){
			count++;
			return;
		}else{
			visited[i][j] = 1;
			if(j-1 >=0 && (grid[i][j-1] == 0 || grid[i][j-1] == 2)){
				findPaths(grid,zeroes+1,total,i,j-1,row,col);
			}

			if(j+1 < col && (grid[i][j+1] == 0 || grid[i][j+1] == 2)){
				findPaths(grid,zeroes+1,total,i,j+1,row,col);
			}

			if(i-1 >=0  && (grid[i-1][j] == 0 || grid[i-1][j] == 2)){
				findPaths(grid,zeroes+1,total,i-1,j,row,col);
			}

			if(i+1 < row && (grid[i+1][j] == 0 || grid[i+1][j] == 2)){
				findPaths(grid,zeroes+1,total,i+1,j,row,col);
			}
			visited[i][j] = 0;
		}
	}
}
