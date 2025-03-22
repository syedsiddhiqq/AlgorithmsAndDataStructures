package LeetCode.medium;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 15-04-2022, Friday, 15:13
 */
public class StartAndEndInSortedArray {
    private static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums.length == 0) return result;
        int startIndex = lowerBound(nums, target);
        if (nums[startIndex] == target || (startIndex + 1 < nums.length && nums[startIndex + 1] == target)) {
            if (nums[startIndex] != target) {
                startIndex = startIndex + 1;
            }
            result[0] = result[1] = startIndex;
            int count = 0;
            while (++startIndex < nums.length) {
                if (nums[startIndex] == target) {
                    count++;
                }
            }
            result[1] = result[0] + count;
            return result;
        }
        return result;
    }

    private static int lowerBound(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (key <= arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0 , 0,0,0,0};
        int[] result = searchRange(nums, 3);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
