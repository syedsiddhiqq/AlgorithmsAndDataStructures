package LeetCode.contests.weeklyContest419;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class XSumOfLongArray2 {

    public long[] findXSumV1(int[] nums, int k, int x) {
        TreeSet<long[]> left = new TreeSet<>(
                (o, p) -> o[0] == p[0] ? Long.compare(o[1], p[1]) : Long.compare(o[0], p[0])),
                right = new TreeSet<>((o, p) -> o[0] == p[0] ? Long.compare(p[1], o[1]) : Long.compare(p[0], o[0]));
        HashMap<Integer, long[]> map = new HashMap<>();
        long sum = 0;
        long[] result = new long[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (left.contains(map.getOrDefault(nums[i], new long[2]))) {
                left.remove(map.get(nums[i]));
                sum -= nums[i] * map.get(nums[i])[0];
            }
            right.remove(map.getOrDefault(nums[i], new long[2]));
            map.put(nums[i], new long[]{map.getOrDefault(nums[i], new long[1])[0] + 1, nums[i]});
            right.add(map.get(nums[i]));
            if (i >= k - 1) {
                while (left.size() < x && !right.isEmpty()) {
                    sum += right.first()[0] * right.first()[1];
                    left.add(right.pollFirst());
                }
                result[i - k + 1] = sum;
                if (left.contains(map.getOrDefault(nums[i - k + 1], new long[2]))) {
                    left.remove(map.get(nums[i - k + 1]));
                    sum -= nums[i - k + 1] * map.get(nums[i - k + 1])[0];
                }
                right.remove(map.getOrDefault(nums[i - k + 1], new long[2]));
                map.put(nums[i - k + 1],
                        new long[]{map.getOrDefault(nums[i - k + 1], new long[1])[0] - 1, nums[i - k + 1]});
                right.add(map.get(nums[i - k + 1]));
                if (!left.isEmpty()) {
                    sum -= left.first()[0] * left.first()[1];
                    right.add(left.pollFirst());
                }
            }
        }
        return result;
    }

    public long[] findXSum(int[] nums, int k, int x) {
        TreeSet<long[]> treeset = new TreeSet<>((a, b) -> {
            // If freq count is same, then compare by value
            if (a[0] == b[0]) {
                return Long.compare(b[1], a[1]);
            } else {
                // Else sort by freq count.
                return Long.compare(b[0], a[0]);
            }
        });

        Map<Integer, long[]> freqMap = new HashMap<>();
        int n = nums.length;
        long[] result = new long[n - k + 1];

        // Building initial freq map and treeset
        for (int i = 0; i < k; i++) {
            treeset.remove(freqMap.getOrDefault(nums[i], new long[2]));
            freqMap.put(nums[i], new long[]{freqMap.getOrDefault(nums[i], new long[1])[0] + 1, nums[i]});
            treeset.add(freqMap.get(nums[i]));
        }

        int itr = 0;
        // Adding top x most element to result.
        for (long[] freqElement : treeset) {
            result[0] += freqElement[0] * freqElement[1];
            if (++itr == x) break;
        }

        // Performing sliding window.
        for (int i = 1; i + k <= n; i++) {
            int outElementIndex = i - 1;
            int inElementIndex = i + k - 1;

            // Removing in and out element
            long[] outElementArr = freqMap.get(nums[outElementIndex]);
            long[] intElementArr = freqMap.getOrDefault(nums[inElementIndex], new long[]{0, inElementIndex});
            treeset.remove(outElementArr);
            treeset.remove(intElementArr);

            // Updating freqmap.
            freqMap.put(nums[outElementIndex], new long[]{freqMap.get(nums[outElementIndex])[0] - 1, nums[outElementIndex]});
            freqMap.put(nums[inElementIndex], new long[]{freqMap.getOrDefault(nums[inElementIndex], new long[1])[0] + 1, nums[inElementIndex]});

            // Adding in and out element with updated frequency back into treeset
            treeset.add(freqMap.get(nums[outElementIndex]));
            treeset.add(freqMap.get(nums[inElementIndex]));

            // Adding top x most element to result.
            itr = 0;
            for (long[] freqElement : treeset) {
                result[i] += freqElement[0] * freqElement[1];
                if (++itr == x) break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        XSumOfLongArray2 solver = new XSumOfLongArray2();
        int[] nums = {1,1,2,2,3,4,2,3};
        int k = 6;
        int x = 2;

        long[] result = solver.findXSumV1(nums, k, x);
        System.out.println(Arrays.toString(result));  // Expected Output: [6, 10, 12]
    }
}
