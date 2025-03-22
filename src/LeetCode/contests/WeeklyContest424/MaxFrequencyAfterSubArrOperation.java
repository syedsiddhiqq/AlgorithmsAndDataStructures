package LeetCode.contests.WeeklyContest424;

import java.util.*;

public class MaxFrequencyAfterSubArrOperation {
    private static class Pair {
        int id;
        int frequency;

        public Pair(int id, int frequency) {
            this.id = id;
            this.frequency = frequency;
        }
    }

    private static void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static int maxFrequency(int[] nums, int k) {
        int fromLeft = maxFreqUtil(nums, k);
        reverse(nums);
        int fromRight = maxFreqUtil(nums, k);
        return Math.max(fromLeft, fromRight);
    }

    private static int maxFreqUtil(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.frequency - a.frequency);
        Map<Integer, Pair> freqMap = new HashMap<>();
        int maxFreq = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != k) {
                Pair pair = freqMap.getOrDefault(nums[i], new Pair(nums[i], 0));
                pair.frequency++;
                freqMap.put(nums[i], pair);
            }else{
                maxFreq++;
            }
        }
        pq.addAll(freqMap.values());
        maxFreq = Math.max(maxFreq, pq.peek().frequency);
        for (int i = 0; i < n; i++) {
            Pair pair = freqMap.getOrDefault(nums[i], new Pair(nums[i], 0));
            if (nums[i] != k) {
                pair.frequency--;
            } else {
                pair.frequency++;
            }
            freqMap.put(nums[i], pair);
            // pq.add(pair);
            Pair kPair = freqMap.getOrDefault(k, new Pair(k, 0));
            maxFreq = Math.max(maxFreq, pq.peek().frequency + kPair.frequency);
        }
        return maxFreq;
    }

    public static int maxFrequencyGPT(int[] nums, int k) {
        int totalK = 0;
        for (int num : nums) {
            if (num == k) {
                totalK++;
            }
        }

        Set<Integer> deltas = new HashSet<>();
        for (int num : nums) {
            deltas.add(k - num);
        }

        int maxSum = Integer.MIN_VALUE;
        for (int delta : deltas) {
            int currentSum = 0;
            int maxCurrentSum = Integer.MIN_VALUE;
            for (int num : nums) {
                int val = ((k - num) == delta ? 1 : 0) - (num == k ? 1 : 0);
                currentSum = Math.max(val, currentSum + val);
                maxCurrentSum = Math.max(maxCurrentSum, currentSum);
            }
            maxSum = Math.max(maxSum, maxCurrentSum);
        }

        return maxSum + totalK;
    }


    public static void main(String[] args) {
        int[] arr = {10, 2, 3, 4, 5, 5, 4, 3, 2, 2};
        System.out.println(maxFrequencyGPT(arr, 10));
    }
}
