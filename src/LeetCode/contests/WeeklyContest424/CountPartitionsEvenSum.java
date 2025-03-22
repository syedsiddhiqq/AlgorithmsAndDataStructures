package LeetCode.contests.WeeklyContest424;

import java.util.List;

public class CountPartitionsEvenSum {
    public static int countPartitions(int[] nums) {
        int sum = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        int partitions = 0;
        int leftParitition = 0;
        for (int i = 0; i < n - 1; i++) {
            leftParitition += nums[i];
            int rightPartition = Math.abs(leftParitition - sum);
            if (Math.abs(leftParitition - rightPartition) % 2 == 0) {
                partitions++;
            }
        }
        return partitions;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,6,8};
        // System.out.println(countPartitions(arr));
        String id = "id100 id23 id35";
        // System.out.println(id.substring(2));
        String[] ids = id.split(" ");

    }
}
