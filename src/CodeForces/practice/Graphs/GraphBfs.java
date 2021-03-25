package CodeForces.practice.Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Syed Ali.
 * @createdAt 25/03/2021, Thursday, 03:33
 */
public class GraphBfs {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		while (T-- > 0) {
			String[] s = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
			for (int i = 0; i < V; i++)
				adj.add(i, new ArrayList<Integer>());
			for (int i = 0; i < E; i++) {
				String[] S = br.readLine().trim().split(" ");
				int u = Integer.parseInt(S[0]);
				int v = Integer.parseInt(S[1]);
				adj.get(u).add(v);
				// adj.get(v).add(u);
			}
			Solution obj = new Solution();
			ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
			for (int i = 0; i < ans.size(); i++)
				System.out.print(ans.get(i) + " ");
			System.out.println();
		}
	}

	static class Solution {

		void bfs(LinkedList<Integer> queue,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> result,int[] visited){
			while(!queue.isEmpty()){
				int node = queue.poll();
				visited[node] = 1;
				result.add(node);
				ArrayList<Integer> nodes = adj.get(node);
				for(int i=0;i<nodes.size();i++){
					if(visited[nodes.get(i)] == 0){
						queue.add(nodes.get(i));
					}
				}
			}
		}

		public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
			int[] visited = new int[V];
			ArrayList<Integer> result = new ArrayList<>();
			LinkedList<Integer> queue = new LinkedList<>();
			queue.add(0);
			bfs(queue,adj,result,visited);
			return result;
		}
	}
}
