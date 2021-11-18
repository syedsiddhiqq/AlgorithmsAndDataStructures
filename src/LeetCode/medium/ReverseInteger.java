package LeetCode.medium;

/**
 * @author Syed Ali.
 * @createdAt 05/10/2021, Tuesday, 23:39
 */
public class ReverseInteger {
	public static int reverse(int x) {
		int prevRev = 0 , rev= 0;
		while( x != 0){
			rev= rev*10 + x % 10;
			int temp = (rev - x % 10);
			if( temp/ 10 != prevRev){
				return 0;
			}
			prevRev = rev;
			x= x/10;
		}
		return rev;
	}

	public static void main(String[] args) {
		System.out.println(reverse(1534236469));
	}
}
