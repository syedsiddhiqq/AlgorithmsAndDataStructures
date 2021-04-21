package LeetCode.TopInterviewQuestions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Syed Ali.
 * @createdAt 21/04/2021, Wednesday, 18:57
 */
public class FreqSort {
	static class Solution {

		class CharCount implements Comparator<CharCount> {
			Character ch;
			int count;

			CharCount() {

			}

			CharCount(Character ch, int count) {
				this.ch = ch;
				this.count = count;
			}

			@Override
			public int compare(CharCount o1, CharCount o2) {
				if (o1.count > o2.count) {
					return -1;
				}
				if (o1.count < o2.count) {
					return 1;
				}
				return 0;
			}
		}

		public String frequencySort(String s) {
			Map<Character, Integer> freq = new HashMap<>();
			char[] str = s.toCharArray();
			for (int i = 0; i < str.length; i++) {
				freq.put(str[i], freq.getOrDefault(str[i], 0) + 1);
			}

			List<CharCount> freqCount = new ArrayList<>();
			freq.keySet().forEach(key -> {
				CharCount charCount = new CharCount(key, freq.get(key));
				freqCount.add(charCount);
			});

			freqCount.sort(new CharCount());
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < freqCount.size(); i++) {
				char ch = freqCount.get(i).ch;
				for (int j = 0; j < freqCount.get(i).count; j++) {
					result.append(ch);
				}
			}
			return result.toString();
		}
	}

	public static void main(String[] args) {
		new Solution().frequencySort("tree");
	}
}
