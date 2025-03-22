package CodeForces.RoadMap.Diff1400;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 02-05-2022, Monday, 08:49
 */
public class MochaAndDiana {
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

        // Function to add an edge
        // into the graph
        void addEdge(Integer v, Integer w) {
            adj[v].add(w);
            adj[w].add(v);
        }


        void removeEdge(Integer v, Integer w) {
            adj[v].remove(w);
            adj[w].remove(v);
        }


        // A recursive function that
        // uses visited[] and parent to detect
        // cycle in subgraph reachable
        // from vertex v.
        Boolean isCyclicUtil(int v,
                             Boolean visited[], int parent) {
            // Mark the current node as visited
            visited[v] = true;
            Integer i;

            // Recur for all the vertices
            // adjacent to this vertex
            Iterator<Integer> it =
                    adj[v].iterator();
            while (it.hasNext()) {
                i = it.next();

                // If an adjacent is not
                // visited, then recur for that
                // adjacent
                if (!visited[i]) {
                    if (isCyclicUtil(i, visited, v))
                        return true;
                }

                // If an adjacent is visited
                // and not parent of current
                // vertex, then there is a cycle.
                else if (i != parent)
                    return true;
            }
            return false;
        }


        Boolean isCyclic() {

            // Mark all the vertices as
            // not visited and not part of
            // recursion stack
            Boolean visited[] = new Boolean[V + 1];
            for (int i = 0; i <= V; i++)
                visited[i] = false;

            // Call the recursive helper
            // function to detect cycle in
            // different DFS trees
            for (int u = 0; u <= V; u++) {

                // Don't recur for u if already visited
                if (!visited[u])
                    if (isCyclicUtil(u, visited, -1))
                        return true;
            }

            return false;
        }
    }

    private static void solve() {
        int n = s.nextInt(), m1 = s.nextInt(), m2 = s.nextInt();

        Graph mocha = new Graph(n);
        Graph diana = new Graph(n);

        for (int i = 0; i < m1; i++) {
            Integer x = s.nextInt(), y = s.nextInt();
            mocha.addEdge(x, y);
        }

        for (int i = 0; i < m2; i++) {
            Integer x = s.nextInt(), y = s.nextInt();
            diana.addEdge(x, y);
        }


        int op = 0;
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (!mocha.adj[i].contains(j) && !diana.adj[i].contains(j)) {
                    mocha.addEdge(i, j);

                    if (!mocha.isCyclic()) {
                        diana.addEdge(i, j);
                        if (!diana.isCyclic()) {
                            op++;
                            result.add(i + " " + j);
                        } else {
                            mocha.removeEdge(i, j);
                            diana.removeEdge(i, j);
                        }
                    } else {
                        mocha.removeEdge(i, j);
                    }
                }
            }
        }
        System.out.println(op);
        for (String s1 : result) {
            System.out.println(s1);
        }
    }

    public static void main(String[] args) {
        solve();
        s.close();
    }
}
