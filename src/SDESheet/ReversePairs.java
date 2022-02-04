package SDESheet;

import java.util.Arrays;

/**
 * @author Syed Ali.
 * @createdAt 28/11/2021, Sunday, 12:35
 */
public class ReversePairs {
	public static int reversePairs(int[] nums) {
		mergeSort(nums,0,nums.length - 1);
		for(int i=0;i<nums.length;i++){
			System.out.println(nums[i]);
		}
		return 0;
	}

	private static void mergeSort(int[] nums,int start, int end){
		if(start < end){
			int mid = (start + end)/2;

			mergeSort(nums,start,mid);
			mergeSort(nums,mid+1,end);

			merge(nums,start,mid,end);
		}
	}



	private static void merge(int[] nums,int i,int mid ,int j){
		int[] mergedArray = new int[j - i + 1];
		int lStart = i,rStart = mid+1;
		int currentIndex = 0;
		while(lStart<=mid && rStart <= j){
			if(nums[lStart] <= nums[rStart]){
				mergedArray[currentIndex++] = nums[lStart++];
			}else{
				mergedArray[currentIndex++] = nums[rStart++];
			}
		}

		while(lStart<=mid){
			mergedArray[currentIndex++] = nums[lStart++];
		}

		while(rStart <= j){
			mergedArray[currentIndex++] = nums[rStart++];
		}

		for(int k=0;k<currentIndex;k++,i++){
			nums[i] = mergedArray[k];
		}
	}

	public static void main(String[] args) {
		int[] arr = {1,3,2,3,1};
		reversePairs(arr);
	}
}
