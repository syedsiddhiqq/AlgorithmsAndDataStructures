package LeetCode.TopInterviewQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author Syed Ali.
 * @createdAt 21/04/2021, Wednesday, 19:11
 */
public class FreqSortUsingBucketSort {
	static public class Solution {
		public String frequencySort(String s) {
			Map<Character, Integer> map = new HashMap<>();
			for (char c : s.toCharArray())
				map.put(c, map.getOrDefault(c, 0) + 1);

			List<Character> [] bucket = new List[s.length() + 1];
			for (char key : map.keySet()) {
				int frequency = map.get(key);
				if (bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
				bucket[frequency].add(key);
			}

			StringBuilder sb = new StringBuilder();
			for (int pos = bucket.length - 1; pos >= 0; pos--)
				if (bucket[pos] != null)
					for (char c : bucket[pos])
						for (int i = 0; i < pos; i++)
							sb.append(c);

			return sb.toString();
		}
	}

	public static void main(String[] args) {
		new FreqSortUsingBucketSort.Solution().frequencySort("tree");
	}
}
