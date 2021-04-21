package LeetCode.TopInterviewQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Syed Ali.
 * @createdAt 21/04/2021, Wednesday, 17:32
 */
public class SearchSuggestions {
	static class Solution {
		public List<List<String>> suggestedProducts(String[] products, String searchWord) {
			List<List<String>> result = new ArrayList<>();
			LinkedList<String> temp = new LinkedList<>();
			temp.offer("t");
			Map<String, List<String>> data = new HashMap<>();
			for (int i = 0; i < searchWord.length(); i++) {
				String substr = searchWord.substring(0, i + 1);
				// System.out.println(substr);
				List<String> tempList = new ArrayList<>();
				data.put(substr, tempList);
				for (int j = 0; j < products.length; j++) {
					if (i < products[j].length()) {
						String substrOfProduct = products[j].substring(0, i + 1);
						if (substr.equals(substrOfProduct)) {
							data.get(substr).add(products[j]);
						}
					}
				}
				Collections.sort(data.get(substr));
				// System.out.println(data.get(substr));
				result.add(data.get(substr).stream().limit(3).collect(Collectors.toList()));
			}
			return result;
		}
	}
}
