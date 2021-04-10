package LeetCode.TopInterviewQuestions;

/**
 * @author Syed Ali.
 * @createdAt 10/04/2021, Saturday, 14:00
 */
public class OddEvenLinkedList {
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

	static class Solution {
		public ListNode oddEvenList(ListNode head) {
			if (head == null) return null;
			ListNode oddNode = head, evenNode = head.next, evenHead = evenNode;
			while (evenNode != null && evenNode.next != null) {
				oddNode.next = evenNode.next;
				oddNode = oddNode.next;
				evenNode.next = oddNode.next;
				evenNode = evenNode.next;
			}
			oddNode.next = evenHead;
			return head;
		}
	}
}
