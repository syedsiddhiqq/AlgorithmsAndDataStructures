package LeetCode.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Syed Ali.
 * @createdAt 04/12/2021, Saturday, 19:34
 */
public class CombinatonSum2 {
	static List<List<Integer>> result = new ArrayList<>();

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		findCombinationSums(candidates,0,candidates.length,target,new ArrayList<>());
		return result;
	}

	private static void findCombinationSums(int[] arr, int start, int n, int target, List<Integer> temp){
		if(target == 0){
			result.add(new ArrayList<>(temp));
			return;
		}else{
			for(int i=start;i<n;i++){
				temp.add(arr[i]);
				findCombinationSums(arr,i+1,n,target - arr[start],temp);
				temp.remove(temp.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = {10,1,2,7,6,1,5};
		combinationSum2(arr,8);
	}
}
