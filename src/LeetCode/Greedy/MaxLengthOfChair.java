package LeetCode.Greedy;

import java.util.Arrays;

/**
 * @author Syed Ali.
 * @createdAt 03/12/2021, Friday, 19:50
 */
public class MaxLengthOfChair {
	public static int findLongestChain(int[][] pairs) {
		Arrays.sort(pairs,(a, b)->{
			return a[1] - b[1];
		});

		int endChairLen = pairs[0][1];
		int count = 0;
		for(int i=1;i<pairs.length;i++){
			if(pairs[i][0] > endChairLen){
				endChairLen = pairs[i][1];
			}else{
				count++;
			}
		}
		return pairs.length - count;
	}

	public static void main(String[] args) {
		int[] arr1 = {1,2};
		int[] arr2 = {2,3};
		int[] arr3 = {3,4};
		int[][] input = new int[3][2];
		input[0] = arr1;
		input[1] = arr2;
		input[2] = arr3;
		findLongestChain(input);
	}
}
