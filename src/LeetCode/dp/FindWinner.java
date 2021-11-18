package LeetCode.dp;

/**
 * @author Syed Ali.
 * @createdAt 31/08/2021, Tuesday, 08:24
 */
public class FindWinner {
	public int findTheWinner(int n, int k) {
		return (n == 1) ? 1 : (findTheWinner(n - 1, k) + k - 1) % n + 1;
	}

	public static void main(String[] args) {
		FindWinner findWinner = new FindWinner();
		System.out.println(findWinner.findTheWinner(6,5));
	}
}
