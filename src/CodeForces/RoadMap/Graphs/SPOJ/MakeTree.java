package CodeForces.RoadMap.Graphs.SPOJ;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

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
		boolean visited = false;

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

	static void topologicalSortDFS(Node[] nodes, int src,Stack<Integer> stack){
		nodes[src].visited = true;
		for(int i=0;i<nodes[src].adj.size();i++){
			int node = nodes[src].adj.get(i).id;
			if(!nodes[node].visited){
				topologicalSortDFS(nodes,node,stack);
			}
		}
		stack.push(src);
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

//		int[] resultArr = new int[n+1];

		Stack<Integer> result = new Stack<>();

		for(int i=1;i<=n;i++){
			if(!nodes[i].visited){
				topologicalSortDFS(nodes,i,result);
			}
		}

		int prev = 0;
		int[] parent = new int[n+1];

		while (!result.empty()) {
			int node = result.pop();
			parent[node] = prev;
			prev = node;
		}

		for (int i = 1; i <= n; ++i) {
			System.out.println(parent[i]);
		}
	}
}
