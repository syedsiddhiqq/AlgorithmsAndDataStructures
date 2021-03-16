//package HackerRank;
//
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Scanner;
//
///**
// * @author Syed Ali.
// * @createdAt 12/03/2021, Friday, 14:27
// */
//public class DeleteNodeLinkedList {
//}
//
//import java.io.*;
//		import java.math.*;
//		import java.security.*;
//		import java.text.*;
//		import java.util.*;
//		import java.util.concurrent.*;
//		import java.util.regex.*;
//
//public class Solution {
//
//	static class SinglyLinkedListNode {
//		public int data;
//		public SinglyLinkedListNode next;
//
//		public SinglyLinkedListNode(int nodeData) {
//			this.data = nodeData;
//			this.next = null;
//		}
//	}
//
//	static class SinglyLinkedList {
//		public SinglyLinkedListNode head;
//		public SinglyLinkedListNode tail;
//
//		public SinglyLinkedList() {
//			this.head = null;
//			this.tail = null;
//		}
//
//		public void insertNode(int nodeData) {
//			SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);
//
//			if (this.head == null) {
//				this.head = node;
//			} else {
//				this.tail.next = node;
//			}
//
//			this.tail = node;
//		}
//	}
//
//	public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
//		while (node != null) {
//			bufferedWriter.write(String.valueOf(node.data));
//
//			node = node.next;
//
//			if (node != null) {
//				bufferedWriter.write(sep);
//			}
//		}
//	}
//
//	// Complete the deleteNode function below.
//
//	/*
//	 * For your reference:
//	 *
//	 * SinglyLinkedListNode {
//	 *     int data;
//	 *     SinglyLinkedListNode next;
//	 * }
//	 *
//	 */
//	static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
//		if(head == null || head.next == null) return null;
//		SinglyLinkedListNode headNode = head;
//		for(int i=0;i<position-1;i++){
//			head = head.next;
//		}
//		head.next = head.next.next;
//		return headNode;
//	}
//
//	private static final Scanner scanner = new Scanner(System.in);
//
//	public static void main(String[] args) throws IOException {
////		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//		SinglyLinkedList llist = new SinglyLinkedList();
//
//
//		for (int i = 0; i < llistCount; i++) {
//			int llistItem = scanner.nextInt();
//			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//			llist.insertNode	(llistItem);
//		}
//
//		int position = scanner.nextInt();
//
//		SinglyLinkedListNode llist1 = deleteNode(llist.head, position);
//
//		printSinglyLinkedList(llist1, " ", bufferedWriter);
//		bufferedWriter.newLine();
//
//		bufferedWriter.close();
//
//		scanner.close();
//	}
//}
//
