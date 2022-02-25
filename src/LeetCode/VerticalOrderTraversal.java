//package LeetCode;
//
////import HackerRank.Node1;
//
////import javafx.util.Pair;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//import java.util.Set;
//import java.util.TreeMap;
//import java.util.stream.Collectors;
//
///**
// * @author Syed Ali.
// * @createdAt 13/03/2021, Saturday, 12:14
// */
//public class VerticalOrderTraversal {
//	public static List<List<Integer>> verticalTraversal(TreeNode root) {
//		Queue<Pair<Integer,TreeNode>> queue = new LinkedList<>();
//		TreeMap<Integer, Set<Integer>> valueMap  = new TreeMap<>();
//		int start = 0;
//		if(root != null){
//			queue.add(new Pair<>(start,root));
//			while(!queue.isEmpty()){
//				Pair<Integer,TreeNode> node = queue.poll();
//
//				if(valueMap.containsKey(node.getKey())){
//					valueMap.get(node.getKey()).add(node.getValue().val);
//				}else{
//					Set<Integer> newArray = new HashSet<>();
//					newArray.add(node.getValue().val);
//					valueMap.put(node.getKey(),newArray);
//				}
//
//				if(node.getValue().left != null){
//					queue.add(new Pair<>(node.getKey()-1,node.getValue().left));
//				}
//
//				if(node.getValue().right != null){
//					queue.add(new Pair<>(node.getKey()+1,node.getValue().right));
//				}
//			}
//		}
//		List<List<Integer>> resul = new ArrayList<>();
//		valueMap.values().forEach(value-> resul.add(new ArrayList<>(value)));
//		return resul;
//	}
//
//	public static TreeNode insert(TreeNode root,Integer data) {
//		if(root == null) {
//			return new TreeNode(data);
//		} else {
//			TreeNode cur;
//			if(data <= root.val) {
//				cur = insert(root.left, data);
//				root.left = cur;
//			} else {
//				cur = insert(root.right, data);
//				root.right = cur;
//			}
//			return root;
//		}
//	}
//
//	public static void main(String[] args) {
//		TreeNode root = new TreeNode(3);
//		root.left = new TreeNode(9);
//		root.right = new TreeNode(20);
//		root.right.left = new TreeNode(15);
//		root.right.right = new TreeNode(7);
//
//
//		System.out.println(verticalTraversal(root));
//	}
//}
//
//
//class TreeNode {
//	int val;
//	TreeNode left;
//	TreeNode right;
//
//	TreeNode() {
//	}
//
//	TreeNode(int val) {
//		this.val = val;
//	}
//
//	TreeNode(int val, TreeNode left, TreeNode right) {
//		this.val = val;
//		this.left = left;
//		this.right = right;
//	}
//}
