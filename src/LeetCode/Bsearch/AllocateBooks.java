package LeetCode.Bsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

/**
 * @author Syed Ali.
 * @createdAt 09/12/2021, Thursday, 09:38
 */
public class AllocateBooks {
	public static int books(ArrayList<Integer> A, int B) {

		Vector<Integer> vector = new Vector<>();
//		vector.addElement(2);
		int min = Integer.MAX_VALUE,high = 0;
		for(Integer i : A) {
			min = Math.min(min,i);
			high += i;
		}
		return bsearch(A,B,min,high);
	}

	private static boolean isPossible(ArrayList<Integer> arr,int pages, int givenStudents){
		int students = 0,sum = 0;
		for(int i=0;i<arr.size();i++){
			if(sum + arr.get(i) > pages){
				students++;
				sum = arr.get(i);
			}else{
				sum += arr.get(i);
			}
		}
		return students < givenStudents;
	}

	private static int bsearch(ArrayList<Integer> arr,int b,int low, int high){
		int min = Integer.MAX_VALUE;
		while(low <= high){
			int mid = (low + high)/2;
			if(isPossible(arr, mid, b)) {
				min = Math.min(min,mid);
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
		}
		return min == Integer.MAX_VALUE ? - 1 : min;
	}

	public static void main(String[] args) {
		Integer[] arr = new Integer[]{12, 34, 67, 90};
		ArrayList<Integer> input = new ArrayList<>(Arrays.asList(arr));
		books(input,2);
	}
}
