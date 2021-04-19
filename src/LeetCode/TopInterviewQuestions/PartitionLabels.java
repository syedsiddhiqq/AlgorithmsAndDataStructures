package LeetCode.TopInterviewQuestions;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Syed Ali.
 * @createdAt 19/04/2021, Monday, 21:01
 */
public class PartitionLabels {
	static public List<Integer> partitionLabels(String S) {
		if(S == null || S.length() == 0){
			return null;
		}
		List<Integer> list = new ArrayList<>();
		int[] map = new int[26];  // record the last index of the each char

		for(int i = 0; i < S.length(); i++){
			map[S.charAt(i)-'a'] = i;
		}
		// record the end index of the current sub string
		int last = 0;
		int start = 0;
		for(int i = 0; i < S.length(); i++){
			last = Math.max(last, map[S.charAt(i)-'a']);
			if(last == i){
				list.add(last - start + 1);
				start = last + 1;
			}
		}
		return list;
	}

	public static void main(String[] args) {
		partitionLabels("ababcbacadefegdehijhklij");
	}
}
