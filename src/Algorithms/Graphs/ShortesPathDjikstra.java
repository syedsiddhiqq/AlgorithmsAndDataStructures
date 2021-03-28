package Algorithms.Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Syed Ali.
 * @createdAt 28/03/2021, Sunday, 11:39
 */
public class ShortesPathDjikstra {

	static  Scanner scanner = new Scanner(System.in);

	static class Node implements Comparator<Node> {
		int node;
		int cost;
		List<Node> adjacentNodes = new ArrayList<>();

		Node(int node){
			this.node = node;
		}

		Node(){

		}

		Node(int node,int cost){
			this.node = node;
			this.cost = cost;
		}


		@Override
		public int compare(Node o1, Node o2) {
			if(o1.cost < o2.cost){
				return -1;
			}else if(o1.cost > o2.cost){
				return 1;
			}
			return 0;
		}
	}

	static void dijkstra(int numberOfNodes,Node[] nodes,Queue<Node> pq,int[] distance,Set<Integer> processed,int[] parent,int src){
		for(int i=0;i<numberOfNodes;i++)
			distance[i] = Integer.MAX_VALUE;

		pq.add(new Node(src,0));
		distance[src] = 0;

		while(!pq.isEmpty() && pq.size() != numberOfNodes){
			int u = pq.poll().node;
			processed.add(u);
			processAdjacentNodes(u,nodes,pq,distance,processed,parent);
		}
	}

	static void processAdjacentNodes(int u,Node[] nodes,Queue<Node> pq,int[] distance,Set<Integer> processed,int[] parent){
		int edgeDistance = -1;
		int newDistance = -1;

		for(int i=0;i<nodes[u].adjacentNodes.size();i++){
			Node v = nodes[u].adjacentNodes.get(i);

			if(!processed.contains(v.node)){
				edgeDistance = v.cost;
				newDistance = distance[u] + edgeDistance;
				if(newDistance < distance[v.node]){
					distance[v.node] = newDistance;
					parent[v.node] = u;
					pq.add(new Node(v.node,distance[v.node]));
				}
			}
		}
	}

	public static void main(String[] args) {
		int numberOfEdges;
		int numberOfNodes;
		numberOfNodes = scanner.nextInt();
		numberOfEdges = scanner.nextInt();


		Queue<Node> pq = new PriorityQueue<>(numberOfNodes,new Node());
		Set<Integer> processed = new HashSet<>();
		int[] distance = new int[numberOfNodes];
		int[] parent = new int[numberOfNodes];
		Node[] nodes =  new Node[numberOfNodes];

		for(int i=0;i<numberOfNodes;i++){
			nodes[i] = new Node(i);
		}

		for(int i=0;i<numberOfEdges;i++){
			int x = scanner.nextInt() - 1;
			int y = scanner.nextInt() - 1;
			int weight = scanner.nextInt();

			nodes[x].adjacentNodes.add(new Node(y,weight));
			nodes[y].adjacentNodes.add(new Node(x,weight));
		}

		dijkstra(numberOfNodes,nodes,pq
				,distance,processed,parent,0);

		System.out.println("The shorted path from node :");
		for (int i = 1; i <= numberOfNodes; i++)
			System.out.println(1 + " to " + i + " is "
					+ distance[i]);
	}
}
