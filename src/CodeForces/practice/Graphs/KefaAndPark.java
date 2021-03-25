//package CodeForces.practice.Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Syed Ali.
 * @createdAt 24/03/2021, Wednesday, 23:06
 */
public class KefaAndPark {
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

	static class Graph {
		List<Integer> adjancencyList = new ArrayList<>();
	}

	static Fs fs = new Fs();

	static void dfs(Graph[] graph, int start, int[] visited, int count, int[] catArr, int m) {
		visited[start] = 1;
		List<Integer> adjacencyList = graph[start].adjancencyList;

		// traversing all the edges of a node.
		for (int i = 0; i < adjacencyList.size(); i++) {
			// if not visited
			int temp = adjacencyList.get(i);
			int cc = count;
			if (visited[temp] == 0) {
				if (catArr[start] == 1 && catArr[temp] == 1) {
					++cc;
				} else if (catArr[temp] == 1) {
					cc = 1;
				} else {
					cc = 0;
				}
				if (cc <= m) {
					dfs(graph, temp, visited, cc, catArr, m);
				}
			}
		}
	}

	public static void main(String[] args) {
		int n, m;
		n = fs.nextInt();
		m = fs.nextInt();


		Graph[] graph = new Graph[n];

		for (int i = 0; i < n; i++) graph[i] = new Graph();

		int[] catArr = new int[n];
		for (int i = 0; i < n; i++) catArr[i] = fs.nextInt();

		for (int i = 0; i < n - 1; i++) {
			int x = fs.nextInt();
			int y = fs.nextInt();
			--x;
			--y;
			graph[x].adjancencyList.add(y);
			graph[y].adjancencyList.add(x);
		}

		int[] visited = new int[n];
		dfs(graph, 0, visited, 1, catArr, m);

		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (visited[i] == 1 && graph[i].adjancencyList.size() == 1 && i != 0) {
				++ans;
			}
		}
		System.out.println(ans);
	}
}
