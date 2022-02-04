package LeetCode.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Syed Ali.
 * @createdAt 05/12/2021, Sunday, 16:03
 */
public class Permutations {
	private static List<List<Integer>> result = new ArrayList<>();
	public static List<List<Integer>> permute(int[] nums) {
		List<Integer> arr = Arrays.stream(nums).boxed().collect(Collectors.toList());
		findPermutations(arr,new ArrayList<>());
		return result;
	}

	private static void findPermutations(List<Integer> arr,List<Integer> temp){
		if(arr.size() == 0){
			result.add(new ArrayList<>(temp));
			return;
		}else{
			for(int i=0;i<arr.size();i++){
				temp.add(arr.get(i));
				arr.remove(i);
				findPermutations(arr,temp);
				arr.add(temp.get(temp.size() - 1));
				temp.remove(temp.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		permute(nums);
	}
}
