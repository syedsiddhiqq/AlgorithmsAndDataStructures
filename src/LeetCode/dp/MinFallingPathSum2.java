package LeetCode.dp;

import java.util.PriorityQueue;

/**
 * @author Syed Ali.
 * @createdAt 30/12/2021, Thursday, 17:45
 */
public class MinFallingPathSum2 {
	private class Pair{
		int index;
		int value;

		Pair(int index,int value){
			this.index = index;
			this.value = value;
		}
	}

	public int minFallingPathSum(int[][]matrix) {
		int row = matrix.length,col = matrix[0].length;
		PriorityQueue<Pair> q = new PriorityQueue<>((a, b)->{
			return a.value - b.value;
		});

		Pair prev = null;

		int sum = 0;
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				q.offer(new Pair(j,matrix[i][j]));
			}
			Pair min = q.poll();
			if(prev != null && min.index == prev.index && !q.isEmpty()){
				min = q.poll();
			}
			prev = min;
			sum += min.value;
			q.clear();
		}
		return sum;
	}

	public static void main(String[] args) {
		MinFallingPathSum2 m = new MinFallingPathSum2();
		int[][] grid = {{-37,51,-36,34,-22},{82,4,30,14,38},{-68,-52,-92,65,-85},{-49,-3,-77,8,-19},{-60,-71,-21,-62,-73}};
		System.out.println(m.minFallingPathSum(grid));
	}
}
