package HackerRank;

/**
 * @author Syed Ali.
 * @createdAt 20/12/2020, Sunday, 06:55
 */
public class ReverseArray {

	static int[] reverseArrayNaive(int[] a) {
		int[] b = new int[a.length];
		for (int i = a.length - 1, count = 0; i >= 0; i--, count++) b[count] = a[i];
		return b;
	}

	static int[] reverseArray(int[] a) {
		int n = a.length,temp;
		for (int i = 0, end = n - 1; i < n / 2; i++, end--) {
			temp = a[i];
			a[i] = a[end];
			a[end] = temp;
		}
		return a;
	}

	public static void main(String[] args) {

	}
}
