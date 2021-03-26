//package CodeForces.practice.Graphs;
//
//import java.io.*;
//import java.util.*;
//
///**
// * @author Syed Ali.
// * @createdAt 25/03/2021, Thursday, 10:37
// */
//public class DetectCyclesInGraph {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(br.readLine().trim());
//		while (T-- > 0) {
//			String[] s = br.readLine().trim().split(" ");
//			int V = Integer.parseInt(s[0]);
//			int E = Integer.parseInt(s[1]);
//			ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//			for (int i = 0; i < V; i++)
//				adj.add(i, new ArrayList<Integer>());
//			for (int i = 0; i < E; i++) {
//				String[] S = br.readLine().trim().split(" ");
//				int u = Integer.parseInt(S[0]);
//				int v = Integer.parseInt(S[1]);
//				adj.get(u).add(v);
//				adj.get(v).add(u);
//			}
//			Solution obj = new Solution();
//			boolean ans = obj.isCycle(V, adj);
//			if (ans)
//				System.out.println("1");
//			else
//				System.out.println("0");
//		}
//	}
//
//	static class Solution {
//
//		Boolean isCyclicUtil(int v,
//							 Boolean visited[], int parent) {
//			// Mark the current node as visited
//			visited[v] = true;
//			Integer i;
//
//			// Recur for all the vertices
//			// adjacent to this vertex
//			Iterator<Integer> it =
//					adj[v].iterator();
//			while (it.hasNext()) {
//				i = it.next();
//
//				// If an adjacent is not
//				// visited, then recur for that
//				// adjacent
//				if (!visited[i]) {
//					if (isCyclicUtil(i, visited, v))
//						return true;
//				}
//
//				// If an adjacent is visited
//				// and not parent of current
//				// vertex, then there is a cycle.
//				else if (i != parent)
//					return true;
//			}
//			return false;
//		}
//
//		static boolean dfs(ArrayList<ArrayList<Integer>> adj, int start, int[] visited) {
//			visited[start] = 1;
//			ArrayList<Integer> adjancentNodes = adj.get(start);
//			for (int i = start; i < adjancentNodes.size(); i++) {
//				if (visited[adjancentNodes.get(i)] == 0) {
//					if (dfs(adj, adjancentNodes.get(i), visited)) {
//						return true;
//					}
//				} else if (adjancentNodes.get(i) != i) {
//					return true;
//				}
//			}
//			return false;
//		}
//
//		public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
////			int[] visited = new int[V];
////			return dfs(adj, 0, visited);
//
//			// Mark all the vertices as
//			// not visited and not part of
//			// recursion stack
//			int visited[] = new int[V];
//			for (int i = 0; i < V; i++)
//				visited[i] = false;
//
//			// Call the recursive helper
//			// function to detect cycle in
//			// different DFS trees
//			for (int u = 0; u < V; u++) {
//
//				// Don't recur for u if already visited
//				if (!visited[u])
//					if (isCyclicUtil(u, visited, -1))
//						return true;
//			}
//
//			return false;
//		}
//	}
//}
