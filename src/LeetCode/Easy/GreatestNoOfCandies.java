package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Syed Ali.
 * @createdAt 14/12/2020, Monday, 16:16
 * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
 */
public class GreatestNoOfCandies {

	public static class Solution{
		public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
			List<Boolean> result = new ArrayList<>();
			int[] copy = candies.clone();
			Arrays.sort(copy);
			int max = copy[copy.length - 1];
			for (int i = 0; i < candies.length; i++) {
				int totalCandies  = candies[i]+extraCandies;
				if(totalCandies >= max) result.add(true);
				else result.add(false);
			}
			return result;
		}
	}
	public static void main(String[] args) {
		int[] candies = {2,3,5,1,3};
		Solution solution =  new Solution();
		List<Boolean> result = solution.kidsWithCandies(candies, 3);
		for (int i = 0; i < solution.kidsWithCandies(candies, 3).size(); i++) {
			System.out.println(result.get(i));
		}
	}
}
