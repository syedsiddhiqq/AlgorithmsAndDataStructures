package LeetCode.TopInterviewQuestions;

/**
 * @author Syed Ali.
 * @createdAt 14/12/2020, Monday, 23:35
 * https://leetcode.com/problems/reverse-string/
 */
public class ReverseAString {
	public static class Solution {
		public void reverseString(char[] s) {
			int start = 0,end = s.length-1;
			while(start<end){
				char temp = s[start];
				s[start] = s[end];
				s[end] = temp;
				start++;
				end--;
			}
		}
	}

	public static void main(String[] args) {

	}
}
