package HackerRank;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 19/12/2020, Saturday, 07:21
 */
public class TemplateClass {
	public static class SinglyLinkedListNode {
		int data;
		SinglyLinkedListNode next;

		public SinglyLinkedListNode(int data) {
			this.data = data;
		}
	}

	static void print(SinglyLinkedListNode head) {
		if (head != null) {
			System.out.println(head.data);
			print(head.next);
		}
	}

	 static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
		if (head == null) {
			head = new SinglyLinkedListNode(data);
		} else if (head.next == null) {
			head.next = new SinglyLinkedListNode(data);
		} else {
			insertNodeAtTail(head.next, data);
		}
		return head;
	}

	static SinglyLinkedListNode getInput() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		SinglyLinkedListNode head = null;
		while (n-- > 0) {
			head = insertNodeAtTail(head, scanner.nextInt());
		}
		return head;
	}

	public static void main(String[] args) {
		SinglyLinkedListNode head = getInput();
		print(head);
	}
}