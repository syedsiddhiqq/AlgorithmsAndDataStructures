package SDESheet;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author Syed Ali.
 * @createdAt 11/12/2021, Saturday, 18:04
 */
public class LFUCache {

	private class Node {
		int key;
		int value;
		int freq = 1;
		Node next;
		Node prev;
		Node tail;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	private int maxFreq = 1;

	private int size;

	private Map<Integer, Node> freqMap = new HashMap<>();

	private Map<Integer, Node> nodeMap = new HashMap<>();

	public LFUCache(int capacity) {
		this.size = capacity;

	}

	private void addInFreqMap(Node node) {
		if (freqMap.containsKey(node.freq)) {
			Node head = freqMap.get(node.freq);
			addNode(head, node);
		} else {
			Node head = new Node(0, 0);
			Node tail = new Node(0, 0);
			head.next = tail;
			tail.prev = head;
			head.tail = tail;
			addNode(head, node);
			freqMap.put(node.freq, head);
		}
	}

	public int get(int key) {
		if (nodeMap.containsKey(key)) {
			Node node = nodeMap.get(key);
			node.freq++;
			mf(node);
			delNode(node);
			addInFreqMap(node);
			return node.value;
		}
		return -1;
	}

	private void mf(Node node) {
		maxFreq = Math.max(node.freq, maxFreq);
	}

	private void addNode(Node head, Node curr) {
		head.next.prev = curr;
		curr.next = head.next;
		head.next = curr;
		curr.prev = head;
	}

	private void delNode(Node curr) {
		curr.prev.next = curr.next;
		curr.next.prev = curr.prev;
	}

	private void removeBeforeTail(Node head) {
		Node tail = head.tail;
		Node nodeToDel = tail.prev;
		delNode(nodeToDel);
		nodeMap.remove(nodeToDel.key);
	}

	public void put(int key, int value) {
		Node node = null;
		if (!nodeMap.containsKey(key)) {
			if (nodeMap.keySet().size() >= size) {
				boolean removed = false;
				for (int i = 1; i <= maxFreq; i++) {
					if (freqMap.containsKey(i)) {
						Node head = freqMap.get(i);
						Node tail = head.tail;
						if(tail.prev != head){
							removeBeforeTail(freqMap.get(i));
							removed = true;
							break;
						}
					}
				}
				if(removed)
					node = new Node(key, value);
			}else{
				node = new Node(key, value);
			}
		} else {
			node = nodeMap.get(key);
			delNode(node);
			node.value = value;
			node.freq++;
			mf(node);
		}

		if(node != null){
			addInFreqMap(node);
			nodeMap.put(key,node);
		}
	}

	public static void main(String[] args) {
		LFUCache lfuCache = new LFUCache(1);
//		lfuCache.put(1,1);
//		lfuCache.put(2,2);
//		System.out.println(lfuCache.get(1));
//		lfuCache.put(3,3);
//		System.out.println(lfuCache.get(2));
//		System.out.println(lfuCache.get(3));
//		lfuCache.put(4,4);
//		System.out.println(lfuCache.get(1));
//		System.out.println(lfuCache.get(3));
//		System.out.println(lfuCache.get(4));

//		lfuCache.put(0,0);
//		System.out.println(lfuCache.get(0));

		lfuCache.put(2,1);
		System.out.println(lfuCache.get(2));
		lfuCache.put(3,2);
		System.out.println(lfuCache.get(2));
		System.out.println(lfuCache.get(3));
	}

}
