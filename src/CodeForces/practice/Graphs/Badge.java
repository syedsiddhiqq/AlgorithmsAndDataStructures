//package CodeForces.practice.Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Syed Ali.
 * @createdAt 27/03/2021, Saturday, 01:20
 */
public class Badge {
	static class Fs {
		private BufferedReader bufferedReader;
		private StringTokenizer stt;


		public Fs() {
			this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		}

		public String nextLine() {
			try {
				return bufferedReader.readLine();
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

		public long nextLong() {
			return Long.parseLong(nextString());
		}
	}

	static Fs fs = new Fs();

	static class Node {
		int i;
		List<Integer> adjNodes = new ArrayList<>();

		Node(int i){
			this.i = i;
		}
	}

	static boolean dfs(Node[] adj,int[] visited,int start){
		if(visited[start] == 1){
			visited[start] =2;
			return true;
		}

		visited[start] = 1;
		for(int i=0;i<adj[start].adjNodes.size();i++){
			if(dfs(adj,visited,adj[start].adjNodes.get(i))){
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int n = fs.nextInt();
		int[] arr = new int[n];
		Node[] nodes = new Node[n+1];
		for(int i=1;i<=n;i++) nodes[i] = new Node(i);
		for(int i=0;i<n;i++){
			arr[i] = fs.nextInt();
			nodes[i+1].adjNodes.add(arr[i]);
		}

		for(int i=1;i<=n;i++){
			int[] visited = new int[n+1];
			visited[i] = 1;
			for(int j=0;j<nodes[i].adjNodes.size();j++){
				if(dfs(nodes,visited,nodes[i].adjNodes.get(j))){
					for(int k=1;k<=n;k++){
						if(visited[k] == 2){
							System.out.print(k+" ");
						}
					}
				}
			}
		}
	}
}
