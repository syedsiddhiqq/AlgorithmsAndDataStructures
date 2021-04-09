package LeetCode.TopInterviewQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Syed Ali.
 * @createdAt 09/04/2021, Friday, 18:16
 */
public class TopKFrequentElements {
	static class Num implements Comparator<Num> {
		int i;
		int count;

		Num(int i, int count) {
			this.i = i;
			this.count = count;
		}

		Num() {

		}

		@Override
		public int compare(Num o1, Num o2) {
			if (o1.count > o2.count) {
				return -1;
			}
			if (o1.count < o2.count) {
				return 1;
			}
			return 0;
		}
	}

	static class Solution {
		public int[] topKFrequent(int[] nums, int k) {
			Map<Integer,Num> data = new HashMap<>();
			for (int temp : nums) {
				if (data.containsKey(temp)) {
					data.put(temp, new Num(temp, data.get(temp).count + 1));
				} else {
					data.put(temp, new Num(temp, 1));
				}
			}


			List<Map.Entry<Integer,Num>> entryList = new LinkedList<>(data.entrySet());
			entryList.sort((o1, o2) -> {
				if(o1.getValue().count > o2.getValue().count){
					return -1;
				}
				if(o1.getValue().count < o2.getValue().count){
					return 1;
				}
				return 0;
			});

			int[] result = new int[k];
			int iter = 0;
			for(int i=0;i<entryList.size();i++){
				if(iter < k){
					result[iter++] = entryList.get(i).getValue().i;
				}else{
					break;
				}
			}
			return result;
		}
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution().topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2)));
	}
}
