package LeetCode.medium;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 24-04-2022, Sunday, 19:54
 */
public class MaxProductSubArr {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int start = 0, n = nums.length;
        int mul = 1;
        while (start < n) {
            mul = mul * nums[start];
            max = Math.max(max, mul);
            max = Math.max(max, nums[start]);
            if (mul < 0 && start + 1 < n && nums[start + 1] < 0) {
                mul = mul * nums[start + 1];
                max = Math.max(max, mul);
                start++;
            } else if (mul < 0) {
                mul = 1;
            }
            start++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-9,-2,-2,2323};
        System.out.println(new MaxProductSubArr().maxProduct(arr));
    }
}
