package LeetCode.dp;

/**
 * @author Syed Ali.
 * @createdAt 29/12/2021, Wednesday, 22:40
 */
public class UniquePaths3 {
	int count = 0;

	public int uniquePathsIII(int[][] grid) {
		int row = grid.length,col = grid[0].length;
		int total = 0,startRow = 0,startCol = 0;
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
		if(i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == -1) return;
		if(grid[i][j] == 2 && zeroes == total){
			count++;
			return;
		}else{
			findPaths(grid,zeroes+1,total,i,j-1,row,col);
			findPaths(grid,zeroes+1,total,i-1,j,row,col);
			findPaths(grid,zeroes+1,total,i,j+1,row,col);
			findPaths(grid,zeroes+1,total,i+1,j,row,col);
		}
	}

	public static void main(String[] args) {
		int[][] grid = {
				{1,0,0,0},
				{0,0,0,0},
				{0,0,2,-1}
		};
		UniquePaths3 u = new UniquePaths3();
		System.out.println(u.uniquePathsIII(grid));
	}
}
