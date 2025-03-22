package LeetCode.medium;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 14-04-2022, Thursday, 12:27
 */
public class ThreeClosestSum {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length, diff = Integer.MAX_VALUE, ans = -1;
        for (int i = 0; i < n; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int j = i + 1, k = n - 1, sum = 0;
                while (j < k) {
                    sum = nums[j] + nums[k] + nums[i];
                    int currDiff = Math.abs(sum - target);
                    if (diff > currDiff) {
                        ans = sum;
                        diff = currDiff;
                    }
                    if (sum < target) {
                        j++;
                        while (sum < target && j < k && nums[j] == nums[j - 1]) j++;
                    } else {
                        k--;
                        while (sum > target && k > j && nums[k] == nums[k + 1]) k--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 1, -3};
        System.out.println(threeSumClosest(arr, 1));
    }
}
