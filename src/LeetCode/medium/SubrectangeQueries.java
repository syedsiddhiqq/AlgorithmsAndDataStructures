package LeetCode.medium;

/**
 * @author Syed Ali.
 * @createdAt 14/12/2020, Monday, 23:22
 */
public class SubrectangeQueries {
	public static class SubrectangleQueries {
		int[][] rectangle;

		public SubrectangleQueries(int[][] rectangle) {
			this.rectangle =  rectangle;
		}

		public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
			for (int i = row1; i <= row2; i++) {
				for (int j = col1; j <= col2; j++) {
					rectangle[i][j] = newValue;
				}
			}
		}

		public int getValue(int row, int col) {
			return rectangle[row][col];
		}
	}

	public static void main(String[] args) {
		int[][] rectangle = {{1,2,1},{4,3,4},{3,2,1},{1,1,1}};
		SubrectangleQueries subrectangleQueries = new SubrectangleQueries(rectangle);
		System.out.println(subrectangleQueries.getValue(0, 2));
	}
}

