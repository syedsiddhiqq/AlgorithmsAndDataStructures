package HackerRank;

import java.util.List;

/**
 * @author Syed Ali.
 * @createdAt 20/12/2020, Sunday, 09:33
 */
public class RotateLeft {
	public static List<Integer> rotateLeft(int d, List<Integer> arr) {
		while(d-->0){
			arr.add(arr.get(0));
			arr.remove(0);
		}
		return arr;
	}
}
