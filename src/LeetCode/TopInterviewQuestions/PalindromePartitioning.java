package LeetCode.TopInterviewQuestions;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Syed Ali.
 * @createdAt 19/04/2021, Monday, 17:47
 */
public class PalindromePartitioning {
	static class Solution {
		public List<List<String>> partition(String s) {
			List<List<String>> res = new ArrayList<List<String>>();
			List<String> list = new ArrayList<String>();
			dfs(s,0,list,res);
			return res;
		}

		public void dfs(String s, int pos, List<String> list, List<List<String>> res){
			if(pos==s.length()) res.add(new ArrayList<String>(list));
			else{
				for(int i=pos;i<s.length();i++){
					if(isPal(s,pos,i)){
						list.add(s.substring(pos,i+1));
						dfs(s,i+1,list,res);
						list.remove(list.size()-1);
					}
				}
			}
		}

		public boolean isPal(String s, int low, int high){
			while(low<high) if(s.charAt(low++)!=s.charAt(high--)) return false;
			return true;
		}

		public static void main(String[] args) {
			new Solution().partition("12345");
		}

	}
}
