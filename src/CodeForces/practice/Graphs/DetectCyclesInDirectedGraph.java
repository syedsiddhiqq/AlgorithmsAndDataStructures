package CodeForces.practice.Graphs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 27/03/2021, Saturday, 00:35
 */
public class DetectCyclesInDirectedGraph {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while(t-- > 0)
		{
			ArrayList<ArrayList<Integer>> list = new ArrayList<>();
			int V = sc.nextInt();
			int E = sc.nextInt();
			for(int i = 0; i < V+1; i++)
				list.add(i, new ArrayList<Integer>());
			for(int i = 0; i < E; i++)
			{
				int u = sc.nextInt();
				int v = sc.nextInt();
				list.get(u).add(v);
			}
			if(new Solution().isCyclic(V, list) == true)
				System.out.println("1");
			else System.out.println("0");
		}
	}

	static class Solution{

		boolean dfs(ArrayList<ArrayList<Integer>> adj, int[] visited,int start){
			// if 1 then already visited and cycle exists
			if(visited[start] == 1)
				return true;

			visited[start] = 1;
			for(int i=0;i<adj.get(start).size();++i){
				if(dfs(adj,visited,adj.get(start).get(i)));
					return true;
			}
			return false;
		}

		boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj){
			int[] visited = new int[V];
			for(int i=0;i<V;++i){
				visited[i] = 1;
				for(int j=0;j<adj.get(i).size();++j){
					if(dfs(adj,visited,adj.get(i).get(j)))
						return true;
				}
				// backtracking and making it false again.
				visited[i] = 0;
			}
			return false;
		}
	}
}
