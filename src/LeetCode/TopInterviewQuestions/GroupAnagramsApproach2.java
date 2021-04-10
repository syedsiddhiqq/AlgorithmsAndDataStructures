package LeetCode.TopInterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Syed Ali.
 * @createdAt 10/04/2021, Saturday, 00:53
 */
public class GroupAnagramsApproach2 {
	static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> data = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			char[] temp = strs[i].toCharArray();
			Arrays.sort(temp);
			String tempStr = String.valueOf(temp);

			if (data.containsKey(tempStr)) {
				data.get(tempStr).add(strs[i]);
			} else {
				List<String> tempList = new ArrayList<>();
				tempList.add(strs[i]);
				data.put(tempStr, tempList);
			}
		}
		return new ArrayList<>(data.values());
	}

	public static void main(String[] args) {
//		System.out.println(new Solution().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
		System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
	}

}
