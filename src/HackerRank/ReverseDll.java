package HackerRank;

/**
 * @author Syed Ali.
 * @createdAt 19/12/2020, Saturday, 21:44
 * https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list/problem
 */
public class ReverseDll extends TemplateClassDll {
	static DoublyLinkedListNode reverse(DoublyLinkedListNode head){
		if(head.next == null){
			return head;
		}
		DoublyLinkedListNode tailNode = reverse(head.next);
		head.prev = head.next;
		head.next.prev = head.next.next;
		head.next.next = head;
		head.next = null;
		return tailNode;
	}
}
