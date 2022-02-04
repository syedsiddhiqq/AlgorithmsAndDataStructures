package LeetCode.DailyChallenge;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Syed Ali.
 * @createdAt 17/01/2022, Monday, 15:11
 */
public class WordPattern {
	public static boolean wordPattern(String pattern, String s) {
		char[] patternArr = pattern.toCharArray();
		String[] words = s.split("\\s+");
		if(patternArr.length != words.length) return false;
		Map<Character, String> map = new HashMap<>();
		map.put(patternArr[0],words[0]);
		for(int i=1;i<patternArr.length;i++){
			if(patternArr[i] == patternArr[i-1] && !words[i].equals(words[i-1])) return false;
			if(map.containsKey(patternArr[i]) && !map.get(patternArr[i]).equals(words[i]))return false;
			map.put(patternArr[i],words[i]);
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(wordPattern("abba","dog cat cat fish"));
	}
}
