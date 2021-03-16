package HackerRank;

/**
 * @author Syed Ali.
 * @createdAt 19/12/2020, Saturday, 10:39
 * https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem
 */
public class MergeNode extends TemplateClass {


	static int findMergeNodeUsingLoop(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
		SinglyLinkedListNode tempNode = head2;
		while (head1 != null) {
			head2 = tempNode;
			while (head2 != null) {
				if (head1 == head2) {
					return head1.data;
				}
				head2 = head2.next;
			}
			head1 = head1.next;
		}
		return 0;
	}

	static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
		if (head2 == null) return 0;
		if (head1 == head2) return head1.data;
		while (head1 != null) {
			findMergeNode(head1, head2);
			head1 = head1.next;
		}
		return 0;
	}

	public static void main(String[] args) {
		SinglyLinkedListNode head1 = getInput();
		SinglyLinkedListNode head2 = getInput();
	}
}
