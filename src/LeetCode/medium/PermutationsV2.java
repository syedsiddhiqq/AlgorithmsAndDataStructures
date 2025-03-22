package LeetCode.medium;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 18-04-2022, Monday, 22:59
 */
public class PermutationsV2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        recurse(nums, new ArrayList<>(),result, used);
        return result;
    }

    private void recurse(int[] nums, List<Integer> temp, List<List<Integer>> result,boolean[] used){
        if(temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
        }else{
            for(int i=0;i<nums.length;i++){
                if(!used[i]){
                    if(i > 0 && (nums[i] == nums[i - 1] && !used[i - 1])) continue;
                    temp.add(nums[i]);
                    used[i] = true;
                    recurse(nums, temp, result,used);
                    used[i] = false;
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1, 2};
        System.out.println(new PermutationsV2().permuteUnique(nums));
    }
}
