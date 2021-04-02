package Algorithms.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 03/04/2021, Saturday, 01:59
 * <p>
 * Topological Sort can be applied in a graph if it passes two criteria
 * 1. It should be directed
 * 2. It should be acyclic [Graph should not have any cycles]
 */
public class TopologicalSort {

	static Scanner scanner = new Scanner(System.in);

	static List<Integer> sortedVertices = new ArrayList<>();

	/**
	 * Class to represent a vertex in a graph
	 */
	static class Node implements Comparator<Node> {
		int id;
		List<Node> adj = new ArrayList<>();
		int inDegree = 0;
		boolean processed = false;

		Node(int i) {
			this.id = i;
		}

		Node() {

		}

		@Override
		public int compare(Node o1, Node o2) {
			if (o1.inDegree < o2.inDegree) {
				return -1;
			} else if (o1.inDegree > o2.inDegree) {
				return 1;
			}
			return 0;
		}
	}

	/**
	 * Method to find vertex with zero indegree
	 *
	 * @param nodes
	 * @param n
	 * @return
	 */
	static int findVertexWithZeroIndegree(Node[] nodes, int n) {
		Queue<Node> pq = new PriorityQueue<>(n, new Node());
		for(int i=1;i<nodes.length;i++){
			if(!nodes[i].processed){
				pq.add(nodes[i]);
			}
		}
		if (!pq.isEmpty()) {
			return pq.peek().id;
		}
		return -1;
	}

	static void topologicalSort(Node[] nodes, int n) {
		// Step 1 : Find any vertex with indegree 0
		while (true) {
			int nodeIndexWithZeroIndegree = findVertexWithZeroIndegree(nodes, n);
			if (nodeIndexWithZeroIndegree != -1) {
				sortedVertices.add(nodeIndexWithZeroIndegree);
				nodes[nodeIndexWithZeroIndegree].processed = true;
				nodes[nodeIndexWithZeroIndegree].adj.forEach(node -> --node.inDegree);
			} else {
				break;
			}
		}
	}

	public static void main(String[] args) {
		// number of vertex
		int n = scanner.nextInt();

		Node[] nodes = new Node[n + 1];
		for (int i = 1; i <= n; i++) {
			nodes[i] = new Node(i);
		}


		// number of edges.
		int m = scanner.nextInt();

		// Construction of adj list
		for (int i = 1; i <= m; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			nodes[x].adj.add(new Node(y));
			++nodes[y].inDegree;
		}

		topologicalSort(nodes,n);

		// Sorted vertices.
		for (int i = 0; i < sortedVertices.size(); i++) {
			System.out.print(sortedVertices.get(i) + " ");
		}
	}
}

/*
Sample input
-------------
6
6
6 3
6 1
5 1
5 2
3 4
4 2
 */
