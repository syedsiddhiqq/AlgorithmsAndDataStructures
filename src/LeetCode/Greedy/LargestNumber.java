package LeetCode.Greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Syed Ali.
 * @createdAt 19/11/2021, Friday, 17:03
 */
public class LargestNumber {
	public String largestNumber(int[] nums) {
		int n = nums.length;
		List<String> strs = new ArrayList<>();
		for(int i=0;i<n;i++){
			strs.add(String.valueOf(nums[i]));
		}

		strs.sort(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2){
				String t1 = s1 + s2;
				String t2 = s2 + s1;
				return t1.compareTo(t2);
			}
		});

		System.out.println(strs.size());
		return null;
	}
}
