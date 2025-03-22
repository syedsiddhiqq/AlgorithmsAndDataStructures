package LeetCode.contests.weeklyContest419;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XSumOfKLongArray {
    private static class Pair{
        int key;
        int count;

        Pair(int key, int count){
            this.key = key;
            this.count = count;
        }
    }

    public static int[] findXSum(int[] nums, int k, int x) {
        int size = nums.length;
        List<Integer> resultList = new ArrayList<>();
        for(int i=0; i + k <= size; i++){
            resultList.add(findXSum(nums, i, i + k, x));
        }
        int[] resultArr = new int[resultList.size()];
        for(int i=0;i<resultList.size();i++) resultArr[i] = resultList.get(i);
        return resultArr;
    }

    private static int findXSum(int[] nums, int start, int end, int x){
        Map<Integer, Pair> freqCount = new HashMap<>();
        for(int i=start;i<end;i++){
            int key = nums[i];
            freqCount.putIfAbsent(key, new Pair(key, 0));
            freqCount.get(key).count++;
        }
        List<Pair> freqList = new ArrayList<>(freqCount.values());
        freqList.sort((p1, p2) -> {
            // Sort by count in descending order
            if (p1.count != p2.count) {
                return Integer.compare(p2.count, p1.count);  // Descending by count
            }
            // If counts are the same, sort by key in descending order
            return Integer.compare(p2.key, p1.key);  // Descending by key
        });
        int result = 0;
        for(int i=0;i<x && i < freqList.size();i++){
            Pair freqPair = freqList.get(i);
            result += freqPair.key * freqPair.count;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {9,2,2};
        System.out.println(findXSum(nums, 3,3 ));
    }
}
