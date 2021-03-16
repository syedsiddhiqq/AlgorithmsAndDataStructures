package HackerRank;

import java.util.HashMap;

/**
 * @author Syed Ali.
 * @createdAt 20/12/2020, Sunday, 10:03
 * https://www.hackerrank.com/challenges/sparse-arrays/problem
 */
public class MatchStrings {
	static int[] matchingStrings(String[] strings, String[] queries) {
		HashMap<String, Integer> stringMap = new HashMap<>();
		int[] result = new int[queries.length];
		for (int i = 0; i < strings.length; i++) {
			if(stringMap.containsKey(strings[i])){
				stringMap.put(strings[i],stringMap.get(strings[i])+1);
			}else{
				stringMap.put(strings[i],1);
			}
		}
		stringMap.entrySet().stream().forEach(stringIntegerEntry -> {
			System.out.println(stringIntegerEntry.getKey()+"::"+stringIntegerEntry.getValue());
		});
		for (int i = 0; i < queries.length; i++) {
			result[i] = stringMap.getOrDefault(queries[i], 0);
		}
		return result;
	}
}
