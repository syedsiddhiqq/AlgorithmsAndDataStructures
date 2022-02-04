package LeetCode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Syed Ali.
 * @createdAt 29/12/2021, Wednesday, 19:03
 */
public class FormWords {
	private static int max = Integer.MIN_VALUE;

	public static int maxScoreWords(String[] words, char[] letters, int[] score) {
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : letters) {
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}
		findMax(words,map,score,0,0,words.length);
		return max;
	}

	private static void findMax(String[] words,Map<Character,Integer> map,int[] scoreMatrix, int score,int start, int end){
		if(start >= end){
			max = Math.max(score,max);
			return;
		}else{
			findMax(words,map,scoreMatrix,score,start+1,end);
			char[] word = words[start].toCharArray();
			Map<Character,Integer> showllowCopy = new HashMap<>(map);
			int tempScore = score;
			for (char ch : word) {
				if (!showllowCopy.containsKey(ch) || showllowCopy.get(ch) == 0) return;
				tempScore += scoreMatrix[ch - 'a'];
				showllowCopy.put(ch, showllowCopy.get(ch) - 1);
			}
			findMax(words,showllowCopy,scoreMatrix,tempScore,start+1,end);
		}
	}

	public static void main(String[] args) {
		String[] words = {"azb","ax","awb","ayb","bpppp"};
		char[] letters = {'z','a','w','x','y','b','p','p','p'};
		int[] score = {10,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,3,2,3,3};
		System.out.println(maxScoreWords(words,letters,score));
	}
}
