package LeetCode.TopInterviewQuestions;

/**
 * @author Syed Ali.
 * @createdAt 15/12/2020, Tuesday, 06:53
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
public class DeleteNodeInLinkedList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public static class Solution{
		public void deleteNode(ListNode node) {
			node.val = node.next.val;
			node.next = node.next.next;
		}
	}

	public static void main(String[] args) {

	}
}
