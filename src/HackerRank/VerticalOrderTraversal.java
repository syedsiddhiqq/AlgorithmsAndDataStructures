package HackerRank;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 13/03/2021, Saturday, 10:27
 */
public class VerticalOrderTraversal {
	public static Node1 insert(Node1 root,Integer data) {
		if(root == null) {
			return new Node1(data);
		} else {
			Node1 cur;
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

	public static void verticalOrder(Node1 root,Integer nodePos, Map<Integer, List<Integer>> valueMap){
		
	}



	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		Node1 root = null;
		while(t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);

		}
		 Map<Integer, List<Integer>> valueMap = new HashMap<>();
		verticalOrder(root,0,valueMap);
		valueMap.values().stream().flatMap(Collection::stream).forEach(System.out::println);
		scan.close();
	}
}




class Node1{
	Integer data;
	Node1 left;
	Node1 right;

	public Node1(Integer data) {
		this.data = data;
	}
}
