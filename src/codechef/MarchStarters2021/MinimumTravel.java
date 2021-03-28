package codechef.MarchStarters2021;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Syed Ali.
 * @createdAt 28/03/2021, Sunday, 18:29
 */
public class MinimumTravel {
	static Scanner scanner = new Scanner(System.in);

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

	static void dijkstra(int numberOfNodes, Node[] nodes, Queue<Node> pq, int[] distance, Set<Integer> processed, int[] parent, int src){
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

	static class Dist implements Comparator<Dist> {
		int id;
		int cost;

		Dist(int id){
			this.id = id;
		}

		Dist(){

		}

		Dist(int id, int cost){
			this.id = id;
			this.cost = cost;
		}

		@Override
		public int compare(Dist o1, Dist o2) {
			if(o1.cost < o2.cost){
				return -1;
			}else if(o1.cost > o2.cost){
				return 1;
			}
			return 0;
		}
	}

	static void solve(){
		int numberOfEdges;
		int numberOfNodes;
		int s;
		int k;
		numberOfNodes = scanner.nextInt()+1;
		numberOfEdges = scanner.nextInt();
		s = scanner.nextInt();
		k = scanner.nextInt();


		Queue<Node> pq = new PriorityQueue<>(numberOfNodes,new Node());
		Set<Integer> processed = new HashSet<>();
		int[] distance = new int[numberOfNodes+1];
		int[] parent = new int[numberOfNodes+1];
		Node[] nodes =  new Node[numberOfNodes+1];

		for(int i=0;i<numberOfNodes;i++){
			nodes[i] = new Node(i);
		}

		for(int i=0;i<numberOfEdges;i++){
			int x = scanner.nextInt();
			int y = scanner.nextInt();
//			int weight = scanner.nextInt();

			nodes[x].adjacentNodes.add(new Node(y,1));
			nodes[y].adjacentNodes.add(new Node(x,1));
		}

		List<Integer> subjects = new ArrayList<>();
		for(int i=0;i<s;i++){
			int temp  = scanner.nextInt();
			subjects.add(temp);
		}

		dijkstra(numberOfNodes,nodes,pq
				,distance,processed,parent,0);

//		System.out.println("The shorted path from node :");
//		for (int i = 1; i < numberOfNodes; i++)
//			System.out.println(0 + " to " + i + " is "
//					+ distance[i]);

		List<Dist> shortestDistances = new ArrayList<>();
		for(int i=1;i<numberOfNodes;i++){
			shortestDistances.add(new Dist(i,distance[i]));
		}

		shortestDistances.sort(new Dist());


		int answer = 0;
		for(int i=0;i<shortestDistances.size() && k > 0;i++){
			if(subjects.contains(shortestDistances.get(i).id)){
				k--;
				answer += shortestDistances.get(i).cost*2;
			}
		}
		System.out.println(answer);
	}

	public static void main(String[] args) {
		int t = scanner.nextInt();
		while(t-->0){
			solve();
		}
	}
}
