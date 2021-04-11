package LeetCode.TopInterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Syed Ali.
 * @createdAt 10/04/2021, Saturday, 15:52
 */
public class Subsets {
	static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
//		list.stream().mapToInt(i->i).sum();
		backtrack(list, new ArrayList<>(), nums, 0);
		return list;
	}

	static  public List<List<Integer>> subsetsWithDup(int[] num) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> empty = new ArrayList<>();
		result.add(empty);
		Arrays.sort(num);

		for (int i = 0; i < num.length; i++) {
			int dupCount = 0;
			while( ((i+1) < num.length) && num[i+1] == num[i]) {
				dupCount++;
				i++;
			}
			int prevNum = result.size();
			for (int j = 0; j < prevNum; j++) {
				List<Integer> element = new ArrayList<>(result.get(j));
				for (int t = 0; t <= dupCount; t++) {
					element.add(num[i]);
					result.add(new ArrayList<>(element));
				}
			}
		}
		return result;
	}

	static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
		list.add(new ArrayList<>(tempList));
		for (int i = start; i < nums.length; i++) {
			tempList.add(nums[i]);
			backtrack(list, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 2};
		subsetsWithDup(nums);
	}
}
