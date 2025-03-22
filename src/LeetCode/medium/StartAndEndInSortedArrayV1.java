package LeetCode.medium;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 15-04-2022, Friday, 15:27
 */
public class StartAndEndInSortedArrayV1 {

    private static Scanner s = new Scanner(System.in);

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

    private static int findFirst(int[] nums, int target) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            if (nums[mid] == target) idx = mid;
        }
        return idx;
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

    private static int findLast(int[] nums, int target) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            if (nums[mid] == target) idx = mid;
        }
        return idx;
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        int[] nums = {0, 0, 0, 0, 0, 0};

        while (t-- > 0) {
            int target = s.nextInt();
//            System.out.println(findFirst());
        }

    }
}
