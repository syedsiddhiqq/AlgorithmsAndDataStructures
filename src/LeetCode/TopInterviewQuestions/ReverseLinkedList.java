package LeetCode.TopInterviewQuestions;

/**
 * @author Syed Ali.
 * @createdAt 15/12/2020, Tuesday, 07:01
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static class Solution {
		public ListNode reverseList(ListNode head) {
//			ListNode nextNode = head.next;
//			ListNode nextNextNode = nextNode.next;
//			head.next = null;
//			nextNode.next = head;
			while(head.next != null){
				ListNode nextNode = head.next;
			}
			return null;
		}
	}

	public static void main(String[] args) {

	}
}
