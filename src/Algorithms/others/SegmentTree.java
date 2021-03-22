package Algorithms.others;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 20/12/2020, Sunday, 15:58
 */
public class SegmentTree {

	static int getMid(int start, int end) {
		return (start + end) / 2;
	}

	/**
	 * Method to construct segment tree.
	 *
	 * @param treeIndex
	 * @param start
	 * @param end
	 */
	static void constructSegmentTree(int[] tree,int[] arr,int treeIndex, int start, int end) {
		if (start == end) {
			// if tree reaches leaf node
			// assign the value in tree
			tree[treeIndex] = arr[start];
		} else {
			int mid = getMid(start, end);
			constructSegmentTree(tree,arr,2 * treeIndex, start, mid);
			constructSegmentTree(tree,arr,2 * treeIndex + 1, mid + 1, end);
			tree[treeIndex] = tree[2*treeIndex] + tree[2*treeIndex+1];
		}
	}

	/**
	 * Method to update segment tree
	 *
	 * @param treeNode
	 * @param start
	 * @param end
	 * @param value
	 * @param indexToUpdate
	 */
	static void updateSegmentTree(int[] tree,int treeNode, int start, int end, int value, int indexToUpdate) {
		if (indexToUpdate < start || indexToUpdate > end) return;
		tree[treeNode] += value;
		int mid = getMid(start, end);
		if(start!=end){
			updateSegmentTree(tree,2 * treeNode, start, mid, value, indexToUpdate);
			updateSegmentTree(tree,2 * treeNode + 1, mid + 1, end, value, indexToUpdate);
		}
	}

	/**
	 * Method to get the sum between range.
	 *
	 * @param start
	 * @param end
	 * @param qstart
	 * @param qend
	 * @param treeNode
	 * @return
	 */
	static int getSum(int[] tree,int start, int end, int qstart, int qend, int treeNode) {
		// if the query range lies within the range
		if(qstart<=start && qend>=end) return tree[treeNode];

		// if it lies outside the range
		if (qstart > end || qend < start) return 0;

		int mid = getMid(start, end);
		return getSum(tree,start, mid, qstart, qend, treeNode * 2) +
				getSum(tree,mid + 1, end, qstart, qend, treeNode * 2 + 1);
	}

	private static Scanner scanner = new Scanner(System.in);

	static int[] getInput(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}
		return arr;
	}

	public static void main(String[] args) {
//		int n = scanner.nextInt();
//		int []arr = getInput(n);
		int n = 5;
		int[] arr = {3,7,9,2,1};
		int[] tree = new int[2*n];
		constructSegmentTree(tree,arr,1, 0, n - 1);
		int newValueToUpdate = scanner.nextInt();
		int indexToupdate = scanner.nextInt();
		int diff = Math.abs(arr[indexToupdate] - newValueToUpdate);
		arr[indexToupdate] = newValueToUpdate;
		updateSegmentTree(tree,1, 0, n - 1, diff, indexToupdate);
		System.out.println(getSum(tree,0,n-1,1,3,1));
	}
}
