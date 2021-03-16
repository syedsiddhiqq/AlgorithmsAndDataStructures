package HackerRank;

/**
 * @author Syed Ali.
 * @createdAt 19/12/2020, Saturday, 11:27
 * https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem
 */
public class InsertANodeDll extends TemplateClassDll {
	static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
		if(head == null) return head;
		else{
			if(head.data > data){
				DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
				head.prev.next = newNode;
				newNode.prev = head.prev;
				newNode.next = head;
				head.prev = newNode;
			}
			sortedInsert(head.next,data);
		}
		return head;
	}

	static DoublyLinkedListNode sortedInsertUsingLoop(DoublyLinkedListNode head, int data) {
		boolean inserted = false;
		DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
		DoublyLinkedListNode headNode = head,tailNode = null;
		if(head == null) return newNode;
		while(head != null){
			if(data <= head.data){
				newNode.next = head;
				newNode.prev = head.prev;
				if(head.prev != null){
					head.prev.next = newNode;
				}else{
					headNode = newNode;
				}
				head.prev = newNode;
				inserted = true;
				break;
			}
			if(head.next == null) tailNode = head;
			head = head.next;
		}

		if(!inserted){
			if(data > tailNode.data){
				newNode.next = tailNode.next;
				newNode.prev = tailNode;
				tailNode.next = newNode;
			}
		}
		return headNode;
	}

	public static void main(String[] args) {
		DoublyLinkedListNode head = getInput();
		head = sortedInsertUsingLoop(head,1);
		print(head);
	}
}
