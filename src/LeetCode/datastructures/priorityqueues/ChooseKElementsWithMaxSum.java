package LeetCode.datastructures.priorityqueues;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ChooseKElementsWithMaxSum {

    public static long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pairs.add(new int[]{nums1[i], i});
        }

        pairs.sort(Comparator.comparingInt(a -> a[0]));
        long[] result = new long[n];
        for (int i = 0; i < n; i++) {
            long sum = 0;
            int[] pair = pairs.get(i);
            List<int[]> removeElements = new ArrayList<>();
            int kCounter = k;
            while (!pq.isEmpty() && kCounter > 0) {
                int[] topElement = pq.poll();
                removeElements.add(topElement);
                if (topElement[1] < pair[0]) {
                    sum += topElement[0];
                    kCounter--;
                }
            }
            pq.addAll(removeElements);
            pq.offer(new int[]{nums2[pair[1]], pair[0]});
            result[pair[1]] = sum;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 2, 2, 2}, nums2 = {3, 1, 2, 3};
        int k = 1;
        System.out.println(findMaxSum(nums1, nums2, k));
    }
}
