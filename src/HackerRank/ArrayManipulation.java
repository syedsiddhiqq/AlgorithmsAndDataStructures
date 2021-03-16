package HackerRank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 20/12/2020, Sunday, 12:28
 * https://www.hackerrank.com/challenges/crush/problem
 */
public class ArrayManipulation {

	static int getMid(int start, int end) {
		return (start + end) / 2;
	}

	static void constructSegmentTree(long[] arr, long[] tree, int start, int end, int treeNode) {
		// out of range as start can never be greater than end
		if (start > end)
			return;

		if (start == end) {
			tree[treeNode] = arr[start];
		} else {
			int mid = getMid(start, end);
			constructSegmentTree(arr, tree, start, mid, 2 * treeNode);
			constructSegmentTree(arr, tree, mid + 1, end, 2 * treeNode + 1);
			tree[treeNode] = Math.max(tree[2 * treeNode], tree[2 * treeNode + 1]);
		}
	}

	static void makeUpdates(long[] tree, long[] lazy, int start, int end, int treeNode) {
		tree[treeNode] += lazy[treeNode];

		if (start != end) {
			// since we cannot go further if it is leafNode..
			lazy[2 * treeNode] += lazy[treeNode];
			lazy[2 * treeNode + 1] += lazy[treeNode];
		}
		// making as 0 as all the updates are done..
		lazy[treeNode] = 0;
	}

	static void updateSegmentTree(long[] tree, long[] lazy, int start, int end,
								  int qstart, int qend, int value, int treeNode) {
		// lazy[i] == 0 there are no updates that are pending...
		// lazy[i] != 0 then there are updates that needs to be done.
		if (lazy[treeNode] != 0) {
			makeUpdates(tree, lazy, start, end, treeNode);
		}

		// out of range..
		if (qstart > end || qend < start) return;

		// if query range lies completely within the range..
		if (qstart <= start && qend >= end) {
			tree[treeNode] += value;

			if (start != end) {
				lazy[2 * treeNode] += value;
				lazy[2 * treeNode + 1] += value;
			}
			return;
		}

		// else it overlaps within range..
		int mid = getMid(start, end);
		updateSegmentTree(tree, lazy, start, mid, qstart, qend, value, 2 * treeNode);
		updateSegmentTree(tree, lazy, mid + 1, end, qstart, qend, value, 2 * treeNode + 1);
		tree[treeNode] = Math.max(tree[2 * treeNode], tree[2 * treeNode + 1]);
	}

	static long getMax(long[] tree, long[] lazy, int start, int end, int qstart,
					   int qend, int treeNode) {
		if (lazy[treeNode] != 0) {
			makeUpdates(tree, lazy, start, end, treeNode);
		}

		// out of range
		if (qstart > end || qend < start) return 0;

		// if completely within range...
		if (qstart <= start && qend >= end) return tree[treeNode];

		int mid = getMid(start, end);
		return Math.max(getMax(tree, lazy, start, mid, qstart, qend, 2 * treeNode),
				getMax(tree, lazy, mid + 1, end, qstart, qend, 2 * treeNode + 1));
	}

	// Complete the arrayManipulation function below.
	static long arrayManipulation(int n, int[][] queries) {
		long[] result = new long[n];
		long[] tree = new long[4*n];
		long[] lazy = new long[4*n];
		constructSegmentTree(result, tree, 0, n-1 , 1);
		for (int[] query : queries) {
			updateSegmentTree(tree, lazy, 0, n-1 , query[0]-1, query[1]-1, query[2], 1);
		}
		return getMax(tree, lazy, 0, n-1 , 1, n-1 , 1);
	}

	private static Scanner scanner = new Scanner(System.in);

	static int[][] getInputQueries(int m) {
		int[][] queries = new int[m][3];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < 3; j++) {
				queries[i][j] = scanner.nextInt();
			}
		}
		return queries;
	}

	public static void main(String[] args) throws FileNotFoundException {
//		int n = scanner.nextInt();
//		int m = scanner.nextInt();
//		src/resources/ArrayManipulation.txt
		File file = new File("src/resources/ArrayManipulation.txt");
		Scanner myReader = new Scanner(file);
		int n = 0,m = 0,index = 0;
		int[][] queries = new int[0][];
		while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			String[] inputs = data.split(" ");
			if(inputs.length == 2){
				n = Integer.parseInt(inputs[0]);
				m = Integer.parseInt(inputs[1]);
				queries = new int[m][3];
			}else{
				queries[index][0] = Integer.parseInt(inputs[0]);
				queries[index][1] = Integer.parseInt(inputs[1]);
				queries[index][2] = Integer.parseInt(inputs[2]);
				index++;
			}
		}
		myReader.close();
		System.out.println(arrayManipulation(n, queries));

//		for(int i=0;i<m;i++){
//			for (int j=0;j<3;j++){
//				System.out.print(queries[i][j] + "\t");
//			}
//			System.out.println("\n");
//		}
	}
}
