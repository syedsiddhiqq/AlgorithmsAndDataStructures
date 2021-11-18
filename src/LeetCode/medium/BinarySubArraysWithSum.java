package LeetCode.medium;

/**
 * @author Syed Ali.
 * @createdAt 25/09/2021, Saturday, 18:02
 */
public class BinarySubArraysWithSum {
	public static int numSubarraysWithSum(int[] A, int S) {
		int a = atMost(A, S);
		int b =  atMost(A, S - 1);
		return a - b;
	}

	public static int atMost(int[] A, int S) {
		if (S < 0) return 0;
		int res = 0, i = 0, n = A.length;
		for (int j = 0; j < n; j++) {
			S -= A[j];
			while (S < 0)
				S += A[i++];
			res += j - i + 1;
		}
		return res;
	}

	public static void main(String[] args) {
		int[] A = {1,0,1,0,1};
		System.out.println(numSubarraysWithSum(A,2));
	}
}
