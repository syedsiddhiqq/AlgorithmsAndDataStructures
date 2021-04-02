package CodeForces.RoadMap.Graphs.SPOJ;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 03/04/2021, Saturday, 02:33
 */
public class MakeTree {
	static Scanner scanner = new Scanner(System.in);

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

	static void topologicalSort(Node[] nodes, int n,int[] result) {
		int count = 0;
		// Step 1 : Find any vertex with indegree 0
		while (true) {
			int nodeIndexWithZeroIndegree = findVertexWithZeroIndegree(nodes, n);
			if (nodeIndexWithZeroIndegree != -1) {
				result[nodeIndexWithZeroIndegree] = count++;
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
			int w = scanner.nextInt();
			for(int j=0;j<w;j++){
				int y = scanner.nextInt();
				nodes[i].adj.add(new Node(y));
				++nodes[y].inDegree;
			}
		}

		int[] result = new int[n+1];
		topologicalSort(nodes,n,result);

		for(int i=1;i<=n;i++){
			System.out.println(result[i]);
		}

		// Sorted vertices.
//		for (int i = 0; i < sortedVertices.size(); i++) {
//			System.out.print(sortedVertices.get(i) + " ");
//		}
	}
}
