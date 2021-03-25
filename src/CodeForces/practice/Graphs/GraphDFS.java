package CodeForces.practice.Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author Syed Ali.
 * @createdAt 25/03/2021, Thursday, 03:09
 */
public class GraphDFS {
	static class Solution {
		void dfs(ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> result,int[] visited,int start) {
			visited[start] = 1;
			result.add(start);
			ArrayList<Integer> adjacentNodes = adj.get(start);
			for(int j=0;j<adjacentNodes.size();j++){
				if(visited[adjacentNodes.get(j)] == 0){
					dfs(adj,result,visited,adjacentNodes.get(j));
				}
			}
		}

		public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
			int[] visited = new int[V];
			ArrayList<Integer> result = new ArrayList<>();
			dfs(adj,result,visited,0);
			return result;
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		while (T-- > 0) {
			String[] s = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
			for (int i = 0; i < V; i++)
				adj.add(new ArrayList<>());
			for (int i = 0; i < E; i++) {
				String[] S = br.readLine().trim().split(" ");
				int u = Integer.parseInt(S[0]);
				int v = Integer.parseInt(S[1]);
				adj.get(u).add(v);
				adj.get(v).add(u);
			}
			Solution obj = new Solution();
			ArrayList<Integer> ans = obj.dfsOfGraph(V, adj);
			for (int i = 0; i < ans.size(); i++)
				System.out.print(ans.get(i) + " ");
			System.out.println();
		}
	}
}
