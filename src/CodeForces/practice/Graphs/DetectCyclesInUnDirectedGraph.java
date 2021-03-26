package CodeForces.practice.Graphs;

import java.io.*;
import java.util.*;

/**
 * @author Syed Ali.
 * @createdAt 25/03/2021, Thursday, 10:37
 */
public class DetectCyclesInUnDirectedGraph {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			ArrayList<ArrayList<Integer>> list = new ArrayList<>();
			int V = sc.nextInt();
			int E = sc.nextInt();
			for (int i = 0; i < V + 1; i++)
				list.add(i, new ArrayList<Integer>());
			for (int i = 0; i < E; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				list.get(u).add(v);
			}
			if (new Solution().isCyclic(V, list))
				System.out.println("1");
			else System.out.println("0");
		}
	}
	static class Solution{

		boolean dfs(ArrayList<ArrayList<Integer>> adj,int[] visited,int start){
			if(visited[start] == 2) return true;

			for(int i=0;i<adj.get(start).size();i++){
				if(visited[i] == 1) visited[i] = 2;
				else {
					if(dfs(adj,visited,i)) return true;
				}
			}
			return false;
		}

		boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
			int[] visited = new int[V];
			for(int i=0;i<V;i++){
				visited[i] = 1;
				for(int j=0;j<adj.get(i).size();i++){
					if(dfs(adj,visited,j)) return true;
				}
			}
			return false;
		}
	}
}

