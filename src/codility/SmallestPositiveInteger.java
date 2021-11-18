package codility;

import java.util.Arrays;

/**
 * @author Syed Ali.
 * @createdAt 18/09/2021, Saturday, 11:39
 */
public class SmallestPositiveInteger {
	public static int solution(int[] A) {
		// write your code in Java SE 8
		int size = (int)(Math.pow(10,5)+1);
		Integer[] freq = new Integer[size];

		Arrays.fill(freq,0);
		for(int i=0;i<A.length;i++){
			if(A[i] > 0){
				++freq[A[i]];
			}
		}

		for(int i=1;i<=size;i++){
			if(freq[i] == 0){
				return i;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] A = {1, 3, 6, 4, 1, 2};
		System.out.println(solution(A));
	}


}
