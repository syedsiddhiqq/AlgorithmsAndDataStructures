package LeetCode.Easy;

import java.util.Arrays;

/**
 * @author Syed Ali.
 * @createdAt 14/12/2020, Monday, 23:04
 */
public class DefangIp {
	public static class Solution{
		public String defangIPaddr(String address) {
			String[] arr = address.split(".");
			return String.join("[.]",address.split("\\."));
		}
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.defangIPaddr("1.1.1.1"));
	}
}
