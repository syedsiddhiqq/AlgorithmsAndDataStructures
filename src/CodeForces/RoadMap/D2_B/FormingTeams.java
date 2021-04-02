//package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 02/04/2021, Friday, 16:39
 */
public class FormingTeams {
	static class Fs{
		private BufferedReader reader;
		private StringTokenizer stt;

		public Fs() {
			reader = new BufferedReader(new InputStreamReader(System.in));
		}

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				return null;
			}
		}

		public String nextString() {
			while (stt == null || !stt.hasMoreTokens()) {
				stt = new StringTokenizer(nextLine());
			}
			return stt.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(nextString());
		}

		public long nextLong(){ return Long.parseLong(nextString()); }
	}

	static Fs fs = new Fs();

	static class Node {
		int id;
		List<Node> adj = new ArrayList<>();
		int color = 0;

		public Node(int id) {
			this.id = id;
		}
	}

	/**
	 * Bfs approach to find whether bipartite graph
	 * using graph coloring.
	 */
	static int bfs(Node[] nodes,int src,int n){
		int answer = 0;
		int[] visited = new int[n];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(src);
		visited[src] = 1;
		while(!queue.isEmpty()){
			int currentNode = queue.poll();
			List<Node> adjNodes = nodes[currentNode].adj;
			for(int i=0;i<adjNodes.size();i++){
				int currentColor = visited[currentNode];
				int node = adjNodes.get(i).id;
				if(visited[node] == 0){
					visited[node] = 3 - currentColor;
					queue.add(node);
				}else if(visited[node] == currentColor){
					++answer;
				}
			}
		}
		return answer;
	}

	static int count = 0;

	static void dfs(Node[] nodes,int src,int[] visited){
		for(int i=0;i<nodes[src].adj.size();i++){
			int node = nodes[src].adj.get(i).id;
			if(visited[node] == 0){
				visited[node] = 3 - visited[src];
				dfs(nodes,node,visited);
			}else if(visited[node] == visited[src]){
				++count;
			}
		}
	}


	/**
	 * Bipartite graph problem
	 * @param args
	 */
	public static void main(String[] args){
		int n = fs.nextInt();
		int m = fs.nextInt();
		Node[] nodes = new Node[n];
		for(int i=0;i<n;i++){
			nodes[i] = new Node(i);
		}

		// construction of adj list.
		for(int i=0;i<m;i++){
			int x = fs.nextInt();
			int y = fs.nextInt();
			--x;
			--y;
			nodes[x].adj.add(new Node(y));
			nodes[y].adj.add(new Node(x));
		}

		int[] visited = new int[n];
		for (int i = 0; i < n; i++) {
			if(visited[i] == 0){
				visited[i] = 1;
				dfs(nodes,i,visited);
			}
		}
//		System.out.println();
//		count = bfs(nodes,0,n);
//		System.out.println(count);
		if(( n - (count/2))%2 == 1) {
			System.out.println(count/2 + 1);
		}else
			System.out.println(count/2);
	}

}
