package SDESheet;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Syed Ali.
 * @createdAt 11/12/2021, Saturday, 15:57
 */
public class LRUCache {
	private int size = 0;

	private class Node{
		int key;
		int value;
		Node next;
		Node prev;

		Node(int key,int value){
			this.key = key;
			this.value = value;
		}
	}

	private Node head = null;

	private Node tail = null;

	private Map<Integer, Node> map = new HashMap<>();

	public LRUCache(int capacity) {
		this.size = capacity;
		Node head = new Node(0,0);
		Node tail = new Node(0,0);
		head.next = tail;
		tail.prev = head;
		this.head = head;
		this.tail = tail;
	}

	public int get(int key) {
		if(map.containsKey(key)){
			Node curr = map.get(key);
			insertAfterHead(curr);
			return curr.value;
		}
		return -1;
	}

	private void insertAfterHead(Node curr){
		curr.prev.next = curr.next;
		curr.next.prev = curr.prev;

		curr.next = head.next;
		curr.next.prev = curr;
		curr.prev = head;
		head.next = curr;
	}

	private void deleteLRU(){
		Node nodeToDel = tail.prev;
		nodeToDel.prev.next = tail;
		tail.prev = nodeToDel.prev;
		map.remove(nodeToDel.key);
	}

	private void insertBeforeTail(Node curr){
		curr.next = tail;
		curr.prev = tail.prev;
		tail.prev = curr;
		curr.prev.next = curr;
	}

	public void put(int key, int value) {
		if(map.containsKey(key)){
			Node curr = map.get(key);
			curr.value = value;
			insertAfterHead(curr);
		}else{
			Node newNode = new Node(key,value);
			if(map.keySet().size() >= size){
				deleteLRU();
			}
			newNode.next = head.next;
			newNode.next.prev = newNode;
			newNode.prev = head;
			head.next = newNode;
			map.put(key,newNode);
		}
	}

	public static void main(String[] args) {
		LRUCache lruCache = new LRUCache(2);
		lruCache.get(2);
		lruCache.put(1,1);
		lruCache.put(2,2);
		lruCache.get(1);
		lruCache.put(3,3);
		lruCache.get(2);
		lruCache.put(4,4);
		lruCache.get(1);
		lruCache.get(3);
		lruCache.get(4);
	}
}
