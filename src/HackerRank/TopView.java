package HackerRank;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 13/03/2021, Saturday, 02:41
 */
public class TopView {
}


class Node {
	Node left;
	Node right;
	int data;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class TopViewSolution {

	/*

    class Node
    	int data;
    	Node left;
    	Node right;
	*/

	public static void topView(Node root) {

		class QueueObj{
			int key;
			Node node;

			public QueueObj(int key, Node node) {
				this.key = key;
				this.node = node;
			}

			public int getKey() {
				return key;
			}

			public Node getNode() {
				return node;
			}
		}

		if(root != null){
			Queue<QueueObj> queue = new LinkedList<>();
			Map<Integer, Integer> valueMap = new HashMap<>();
			int start = 0;
			queue.add(new QueueObj(start,root));
			while(!queue.isEmpty()){
				QueueObj node = queue.poll();
				if(!valueMap.containsKey(node.getKey())){
					valueMap.put(node.getKey(),node.getNode().data);
					System.out.print(node.getNode().data + " ");
				}
				if(node.getNode().left != null){
					queue.add(new QueueObj(node.getKey() - 1,node.getNode().left));
				}
				if(node.getNode().right != null){
					queue.add(new QueueObj(node.getKey() + 1,node.getNode().right));
				}
			}
		}
	}

	public static void levelOrder(Node root) {
		if(root != null){
			Queue<Node> queue = new LinkedList<>();
			queue.add(root);
			while(!queue.isEmpty()){
				Node currentNode = queue.poll();
				System.out.print(currentNode.data+" ");
				if(currentNode.left != null) queue.add(currentNode.left);
				if(currentNode.right != null) queue.add(currentNode.right);
			}
		}
	}

	public static Node insert(Node root, int data) {
		if(root == null) {
			return new Node(data);
		} else {
			Node cur;
			if(data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		Node root = null;
		while(t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);
		}
		scan.close();
		topView(root);
	}
}
