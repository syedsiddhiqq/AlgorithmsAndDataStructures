package LeetCode.medium;

import java.util.Arrays;

/**
 * @author Syed Ali.
 * @createdAt 02/12/2021, Thursday, 12:26
 */
public class FindMinFibOfK {

	public static int findMinFibonacciNumbers(int k) {
		int[] fib = new int[k+1];

		fib[0] = fib[1] = 1;
		for(int i=2;i<=k;i++){
			fib[i] = fib[i-1] + fib[i-2];
		}

		int count = 0;
		int n = k;
		while(k > 0) {
			 int index = findLowerBound(fib,0,n,k) - 1;
//			int index = Arrays.binarySearch(fib, k);
			System.out.println(fib[index - 1]);
			k-=fib[index];
			count++;
		}
		return count;
	}

	private static int findLowerBound(int[] fib, int low, int high, int k){
		while(low < high){
			int mid = (low + high)/2;
			if(fib[mid] >= k){
				high = mid;
			}else {
				low = mid+1;
			}
		}
		return low;
	}

	public static void main(String[] args) {
		System.out.println(findMinFibonacciNumbers(10));
//		System.out.println(findMinFibonacciNumbers(10));
	}
}
