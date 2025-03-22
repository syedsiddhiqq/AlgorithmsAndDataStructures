package LeetCode.contests;

import java.util.Arrays;

public class LargestOutlier {
    public static int largestOutlier(int[] nums) {
        int totalSum = 0;

        // Calculate the total sum of the array
        for (int num : nums) {
            totalSum += num;
        }

        // Sort the array in descending order
        Arrays.sort(nums);
        reverse(nums); // Reverse to make it descending

        int largestOutlier = Integer.MIN_VALUE;

        // Iterate over each number, assuming it's the sum of special numbers
        for (int i = 0; i < nums.length; i++) {
            int potentialSum = nums[i]; // Assume this is the sum of special numbers
            int sumOfSpecialNumbers = totalSum - potentialSum;

            int count = 0;
            int tempSum = sumOfSpecialNumbers;

            // Check if `n-2` numbers can form the sum
            for (int num : nums) {
                if (count < nums.length - 2 && tempSum - num >= 0) {
                    tempSum -= num;
                    count++;
                }
                if (count == nums.length - 2) {
                    break;
                }
            }

            // If we find valid `n-2` numbers, calculate the outliers
            if (count == nums.length - 2) {
                for (int j = 0; j < nums.length; j++) {
                    if (j != i && nums[j] != potentialSum) { // Not the sum element
                        largestOutlier = Math.max(largestOutlier, nums[j]);
                    }
                }
            }
        }

        return largestOutlier;
    }

    // Helper function to reverse an array
    private static void reverse(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {-13,1,2,3};
        System.out.println(largestOutlier(arr));
    }
}
