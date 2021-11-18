package CodeForces.RoadMap.Diff1300;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Given:
 *	n - rectangles each of height 1, width is power of 2.
 *	2 - dimentional box of width W. [W is atleast as as large as the largest rectangle.]
 *
 * To find:
 * 	Smallest height of the box that fits all the given rectangles.
 *
 *
 * Note:
 * 	Allowed to have empty spaces left after filling the rectangles.
 * 	Cannot rotate the given rectangle.
 * 	Any 2 distinct rectangles
 * @author Syed Ali.
 * @createdAt 18/11/2021, Thursday, 14:46
 */
public class BoxFitting {

	private static Scanner s = new Scanner(System.in);

	public static int lowerBound(List<Integer> boxes, long w) {
		int low = -1;
		int high = boxes.size();
		while (high - low > 1) {
			int middle = (low + high)/2;
			if (boxes.get(middle) <= w) {
				low = middle;
			} else {
				high = middle;
			}
		}
		return low;
	}
	private static void solve(){
		long n = s.nextLong(),w = s.nextLong();
		List<Integer> arr = new ArrayList<>();
		for(int i=0;i<n;i++){
			arr.add(s.nextInt());
		}
		Collections.sort(arr);
		int ans = 1;
		long currentWidth = w;
		while(arr.size() > 0){
			int index = lowerBound(arr,currentWidth);
			if(index == -1){
				currentWidth = w;
				++ans;
			}else{
				currentWidth-=arr.get(index);
				arr.remove(index);
			}
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		int t = s.nextInt();
		while(t-->0){
			solve();
		}
	}
}
