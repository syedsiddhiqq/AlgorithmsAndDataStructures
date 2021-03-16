package HackerRank;

/**
 * @author Syed Ali.
 * @createdAt 19/12/2020, Saturday, 07:15
 * https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list/problem
 */
public class RemoveDuplicates extends TemplateClass {

	static SinglyLinkedListNode removeDuplicatesUsingLoop(SinglyLinkedListNode head) {
		SinglyLinkedListNode headNode = head;
		if (head == null) return null;
		while (head.next != null) {
			if (head.data == head.next.data) {
				head.next = head.next.next;
			} else {
				head = head.next;
			}

		}
		return headNode;
	}

		static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
			if (head == null) return null;
			if (head.next != null) {
				if (head.data == head.next.data) {
					head.next = head.next.next;
					removeDuplicates(head);
				} else {
					removeDuplicates(head.next);
				}
			}
			return head;
		}

	public static void main(String[] args) {
		SinglyLinkedListNode head = getInput();
		removeDuplicates(head);
		print(head);
	}
}
