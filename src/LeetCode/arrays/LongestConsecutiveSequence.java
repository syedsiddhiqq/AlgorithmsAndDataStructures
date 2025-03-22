package LeetCode.arrays;

import java.util.*;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        int result = 1;
        for(int i=0;i<nums.length;i++){
            int left = 0, temp = nums[i], right = 0;
            while(map.containsKey(--temp)) {
                left++;
                map.remove(temp);
            }
            temp = nums[i];
            while(map.containsKey(++temp)){
                right++;
                map.remove(temp);
            }
            result = Math.max(result, left + right + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence l = new LongestConsecutiveSequence();
        System.out.println(l.longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
}
