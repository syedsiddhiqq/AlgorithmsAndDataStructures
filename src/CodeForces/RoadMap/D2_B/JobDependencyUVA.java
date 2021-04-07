package CodeForces.RoadMap.D2_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * @author Syed Ali.
 * @createdAt 08/04/2021, Thursday, 01:26
 */
public class JobDependencyUVA {
	static class Fs{
		private BufferedReader reader;
		private StringTokenizer stt;

		public Fs() {
			reader = new BufferedReader(new InputStreamReader(System.in));
		}

		public String nextLine() {
			try {
				return reader.readLine();
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

		public long nextLong(){ return Long.parseLong(nextString()); }
	}

	static Fs fs = new Fs();

	static class Node{
		int id;
		int time;
		List<Integer> adj = new ArrayList<>();

		Node(int id,int time){
			this.id = id;
			this.time = time;
		}
	}

	static void solve(int v,int e){
		Node[] nodes = new Node[v+1];
		for(int i=1;i<=v;i++){
			int time = fs.nextInt();
			nodes[i] = new Node(i,time);
		}

		for(int i=0;i<e;i++){
			int x = fs.nextInt();
			int y = fs.nextInt();

			nodes[x].adj.add(y);
		}

		int q = fs.nextInt();
		for(int i=0;i<q;i++){
			int job = fs.nextInt();

			int sumOfGivenJob = 0,totalTime = 0;
			for(int j=0;j<nodes[job].adj.size();j++){
				sumOfGivenJob += nodes[nodes[job].adj.get(j)].time;
			}

			Queue<Node> queue = new LinkedList<>();
			queue.add(nodes[1]);
			while(!queue.isEmpty()){
				Node node = queue.poll();
				if(node.id != job){
					totalTime+= node.time;
				}

				for(int k=0;k<node.adj.size();k++){
					queue.add(nodes[node.adj.get(k)]);
				}
			}
			System.out.println(totalTime - sumOfGivenJob);
		}
	}

	public static void main(String[] args){
		while(true){
			int v = fs.nextInt();
			int e = fs.nextInt();
			if(v == 0 && e == 0){
				break;
			}else {
				solve(v,e);
				fs.nextLine();
			}
		}
	}
}
