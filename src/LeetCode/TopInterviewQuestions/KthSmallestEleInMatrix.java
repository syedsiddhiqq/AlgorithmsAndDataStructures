package LeetCode.TopInterviewQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * @author Syed Ali.
 * @createdAt 10/04/2021, Saturday, 01:08
 */
public class KthSmallestEleInMatrix {
	static public int kthSmallest(int[][] matrix, int k) {
		System.out.println(matrix.length);
		List<Integer> arr = new ArrayList<>();
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				arr.add(matrix[i][j]);
			}
		}
		Collections.sort(arr);
		return arr.get(k-1);
	}


	public static void main(String[] args) {
//		kthSmallest({{1,5,9},{10,11,13},{12,13,15}},8);
	}
}
