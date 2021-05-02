package CodeForces.RoadMap.D2_B;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 02/05/2021, Sunday, 18:42
 */
public class ShuffleSegTree {

	static Scanner scanner = new Scanner(System.in);

	static int nextPowerOf2(int num) {
		if (num == 0) {
			return 1;
		}
		if (num > 0 && (num & (num - 1)) == 0) {
			return num;
		}
		while ((num & (num - 1)) > 0) {
			num = num & (num - 1);
		}
		return num << 1;
	}

	static void constructSegTree(){

	}

	static void solve() {
		int n, x, m;
		n = scanner.nextInt();
		x = scanner.nextInt();
		m = scanner.nextInt();


		int[] arr = new int[n];
		int nextPowerOf2 = nextPowerOf2(n);
		int[] tree = new int[nextPowerOf2];
		Arrays.fill(tree,Integer.MAX_VALUE);
		for (int i = 0; i < m; i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();

		}
	}

	public static void main(String[] args) {
		int t = scanner.nextInt();
		while (t-- > 0) {
			solve();
		}
	}
}
