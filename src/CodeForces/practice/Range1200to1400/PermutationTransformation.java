//package CodeForces.practice.Range1200to1400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author Syed Ali.
 * @createdAt 22/03/2021, Monday, 23:38
 */
public class PermutationTransformation {
	static class Fs {
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

		public long nextLong() { return Long.parseLong(nextString());}

	}

	static class Node{
		int data;
		Node left;
		Node right;

		Node(int data){
			this.data = data;
		}
	}

	static Map<Integer,Integer> depthMap = new HashMap<>();

	static Fs fs =  new Fs();

	static int fetchHighestFromArr(List<Integer> arr){
		Queue<Integer> heap = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
		for(int i=0;i<arr.size();i++) heap.add(arr.get(i));
		return heap.isEmpty() ? 0:heap.peek();
	}

	static Node constructTree(List<Integer> arr,int depth){
		int data = fetchHighestFromArr(arr);
		Node newNode = new Node(data);
		depthMap.put(data,depth);
		if(arr.size() == 1){
			return newNode;
		}

		int index = arr.indexOf(data);
		if(index > -1 && index < arr.size()){
			// travserse left and right
			newNode.left = constructTree(arr.subList(0,index),depth+1);
			newNode.right = constructTree(arr.subList(index+1,arr.size()),depth+1);
		}

		return newNode;
	}

	static void solve(){
		int n = fs.nextInt();
		List<Integer> arr = new ArrayList<>();
		for(int i=0;i<n;i++) arr.add(fs.nextInt());

		//contruct tree
		int depth = 0;
		int data = fetchHighestFromArr(arr);
		Node root =constructTree(arr,depth);

		for(int i=0;i<arr.size();i++){
			System.out.print(depthMap.get(arr.get(i)) + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		int t = fs.nextInt();
		while(t-->0){
			solve();
		}
	}
}
