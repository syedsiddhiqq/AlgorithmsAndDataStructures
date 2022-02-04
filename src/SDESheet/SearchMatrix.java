package SDESheet;

/**
 * @author Syed Ali.
 * @createdAt 26/11/2021, Friday, 19:18
 */
public class SearchMatrix {
	private static int lowerBound(int[] arr, int key){
		int low = 0, high = arr.length - 1;
		while(low < high){
			int mid = (low+high)/2;
			if(key <= arr[mid]){
				high = mid - 1;
			}else{
				low = mid+1;
			}
		}
		return low;
	}

	private static int bSearch(int[] arr, int key){
		int low = 0, high = arr.length - 1;
		while(low < high){
			int mid = (low+high)/2;
			if(key == arr[mid]){
				return mid;
			}else if(key < mid){
				high = mid- 1;
			}else {
				low = mid + 1;
			}
		}
		return low;
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		int row = matrix.length,col = matrix[0].length;
		int[] rows = new int[row];

		for(int i=0;i<row;i++){
			rows[i] = matrix[i][0];
		}
		int rowToSearch = lowerBound(rows,target);
		int indexOfTarget = bSearch(matrix[rowToSearch],target);
		return matrix[rowToSearch][indexOfTarget] == target;
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3,4, 10, 20 , 30};
		System.out.println(bSearch(arr,25));
	}
}
