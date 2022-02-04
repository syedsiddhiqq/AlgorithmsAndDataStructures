package LeetCode.Greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Syed Ali.
 * @createdAt 29/11/2021, Monday, 12:59
 */
public class LengthOfLongestSubString {
	public static int lengthOfLongestSubstring(String s) {
		Map<Character,Integer> map = new HashMap<>();
		int n = s.length();
		int start = 0,end = 0,count = 0;
		while(start < n && end < n){
			if(!map.containsKey(s.charAt(end))){
				count = Math.max(count, (end - start) + 1);
				map.put(s.charAt(end),end);
				end++;
			}else{
				start = Math.max(start, map.get(s.charAt(end)) + 1);
				map.remove(s.charAt(end));
			}
		}
		return count;
	}

	public static void main(String[] args) {
		lengthOfLongestSubstring("abba");
	}
}
