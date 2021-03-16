package Algorithms;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 23/12/2020, Wednesday, 00:17
 */
public class SegmentTreeLazyForFindingMax {
	static int getMid(int start,int end) {
		return (start+end)/2;
	}

	static void constructSegmentTree(int[] arr,int[] tree,int start,int end,int treeNode){
		if(start == end){
			tree[treeNode] = arr[start];
		}else{
			int mid = getMid(start, end);
			constructSegmentTree(arr,tree,start,mid,2*treeNode);
			constructSegmentTree(arr,tree,mid+1,end,2*treeNode+1);
			tree[treeNode] = Math.max(tree[2*treeNode] , tree[2*treeNode+1]);
		}
	}

	static void makeUpdates(int[] tree,int[] lazy,int start,int end,int treeNode){
		tree[treeNode] += lazy[treeNode];

		if(start!=end){
			// since we cannot go further if it is leafNode..
			lazy[2*treeNode] += lazy[treeNode];
			lazy[2*treeNode+1] += lazy[treeNode];
		}
		// making as 0 as all the updates are done..
		lazy[treeNode] = 0;
	}

	static void updateSegmentTree(int[] tree,int[] lazy,int start,int end,
								  int qstart,int qend,int value,int treeNode){
		// lazy[i] == 0 there are no updates that are pending...
		// lazy[i] != 0 then there are updates that needs to be done.
		if(lazy[treeNode] != 0){
			makeUpdates(tree,lazy,start,end,treeNode);
		}

		// out of range..
		if(qstart>end || qend<start) return;

		// if query range lies completely within the range..
		if(qstart<=start && qend>=end){
			tree[treeNode] += value;

			if(start!=end){
				lazy[2*treeNode] += value;
				lazy[2*treeNode+1] += value;
			}
			return;
		}

		// else it overlaps within range..
		int mid = getMid(start, end);
		updateSegmentTree(tree,lazy,start,mid,qstart,qend,value,2*treeNode);
		updateSegmentTree(tree,lazy,mid+1,end,qstart,qend,value,2*treeNode+1);
		tree[treeNode] = Math.max(tree[2*treeNode] , tree[2*treeNode+1]);
	}

	static int getMax(int[] tree,int[] lazy,int start,int end,int qstart,
					  int qend,int treeNode){
		if(lazy[treeNode]!=0){
			makeUpdates(tree,lazy,start,end,treeNode);
		}

		// out of range
		if(qstart>end || qend < start) return 0;

		// if completely within range...
		if(qstart<=start && qend>=end) return tree[treeNode];

		int mid = getMid(start, end);
		return Math.max(getMax(tree,lazy,start,mid,qstart,qend,2*treeNode),
				getMax(tree,lazy,mid+1,end,qstart,qend,2*treeNode+1));
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] tree,lazy;
		int[] arr = {0,0,0,0,0};
		tree = new int[2*n];
		lazy = new int[2*n];
		constructSegmentTree(arr,tree,0,arr.length-1,1);
		System.out.println(getMax(tree,lazy,0,arr.length-1,0,arr.length-1,1));

		// Adding value to all nodes within range...
		updateSegmentTree(tree,lazy,0,arr.length-1,0,arr.length-1,10,1);
		System.out.println(getMax(tree,lazy,0,arr.length-1,0,arr.length-1,1));
	}
}
