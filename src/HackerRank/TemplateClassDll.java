package HackerRank;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 19/12/2020, Saturday, 11:25
 */
public class TemplateClassDll {
	static class DoublyLinkedListNode{
		int data;
		DoublyLinkedListNode next;
		DoublyLinkedListNode prev;

		public DoublyLinkedListNode(int data) {
			this.data = data;
		}
	}

	static DoublyLinkedListNode insertNodeAtTail(DoublyLinkedListNode head,int data){
		if(head == null) return new DoublyLinkedListNode(data);
		if(head.next != null){
			insertNodeAtTail(head.next,data);
		}else{
			DoublyLinkedListNode newNode =  new DoublyLinkedListNode(data);
			head.next = newNode;
			newNode.prev = head;
		}
		return head;
	}

	static void print(DoublyLinkedListNode head){
		if(head != null){
			System.out.println(head.data);
			print(head.next);
		}
	}

	static DoublyLinkedListNode getInput(){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		DoublyLinkedListNode head = null;
		while(n-->0){
			head = insertNodeAtTail(head,scanner.nextInt());
		}
		return head;
	}

	public static void main(String[] args) {
 		DoublyLinkedListNode head = getInput();
 		print(head);
	}
}
