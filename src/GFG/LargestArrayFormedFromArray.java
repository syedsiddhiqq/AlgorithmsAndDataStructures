package GFG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Syed Ali.
 * @createdAt 06/03/2021, Saturday, 16:39
 */
public class LargestArrayFormedFromArray {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		while (tc-- > 0) {
			String[] inputLine;
			int n = Integer.parseInt(br.readLine().trim());
			String[] arr = br.readLine().trim().split(" ");

			String ans = new LargestArrayFormedSolution().printLargest(arr);
			System.out.println(ans);
		}
	}
}

class LargestArrayFormedSolution {
	String printLargest(String[] arr) {
		Arrays.sort(arr, (X, Y) -> {

			// first append Y at the end of X
			String XY = X + Y;

			// then append X at the end of Y
			String YX = Y + X;

			// Now see which of the two
			// formed numbers
			// is greater
			return XY.compareTo(YX) > 0 ? -1 : 1;
		});
		return String.join("", arr);
	}
}
