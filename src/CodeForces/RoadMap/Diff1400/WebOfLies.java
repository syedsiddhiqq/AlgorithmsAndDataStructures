package CodeForces.RoadMap.Diff1400;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 02-05-2022, Monday, 10:44
 */
public class WebOfLies {
    private static Scanner s = new Scanner(System.in);

    private static class Graph {
        // No. of vertices
        private int V;

        // Adjacency List Representation
        private List<Integer> adj[];

        // Constructor
        Graph(int v) {
            V = v;
            adj = new ArrayList[v + 1];
            for (int i = 0; i <= v; ++i)
                adj[i] = new ArrayList();
        }

        public Graph(Graph graph) {
            this.V = graph.V;
            this.adj = new ArrayList[V + 1];
            for (int i = 0; i <= V; i++)
                adj[i] = new ArrayList<>(graph.adj[i]);
        }

        // Function to add an edge
        // into the graph
        void addEdge(Integer v, Integer w) {
            if (v > w) addEdge(w, v);
            else adj[v].add(w);
        }


        void removeEdge(Integer v, Integer w) {
            adj[v].remove(w);
            adj[w].remove(v);
        }
    }

    private static void solve() {
        int n = s.nextInt(), m = s.nextInt();
        Graph graph = new Graph(n);

        for (int i = 0; i < m; i++) {
            Integer u = s.nextInt(), v = s.nextInt();
            graph.addEdge(u, v);
        }

        int q = s.nextInt();
        Graph graph1 = new Graph(graph);
        while (q-- > 0) {
            int temp = s.nextInt();
            if (temp == 1) {
                Integer u = s.nextInt(), v = s.nextInt();
                graph1.adj[u].add(v);
            } else if (temp == 2) {
                Integer u = s.nextInt(), v = s.nextInt();
                graph1.removeEdge(u, v);
            } else if (temp == 3) {
                int nobles = 1;
                for (Integer i = 1; i < graph1.adj.length - 1; i++) {
                    if (graph1.adj[i].size() == 0) {
                        nobles++;
                    }
                }
                System.out.println(nobles);
                graph1 = new Graph(graph);
            }
        }
    }

    public static void main(String[] args) {
        solve();
        s.close();
    }
}
