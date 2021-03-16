package HackerRank;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Syed Ali.
 * @createdAt 13/03/2021, Saturday, 15:34
 */
public class InsertInABtree {
}


class Solution {

	public static void preOrder( Node root ) {

		if( root == null)
			return;

		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);

	}

 /* Node is defined as :
 class Node
    int data;
    Node left;
    Node right;

    */

	public static Node insert(Node root,int data) {
		if(root == null){
			return new Node(data);
		}else {
			if(data < root.data){
				//traverse left..
				root.left = insert(root.left,data);
			}else{
				// traverse right..
				root.right = insert(root.right,data);
			}
		}
		return root;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Stack stack = new Stack();
		stack.push(12);

		int t = scan.nextInt();
		Node root = null;
		while(t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);
		}
		scan.close();
		preOrder(root);
	}
}
