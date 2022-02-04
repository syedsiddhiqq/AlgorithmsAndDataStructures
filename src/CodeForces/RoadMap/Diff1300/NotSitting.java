//package CodeForces.RoadMap.Diff1300;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 02/02/2022, Wednesday, 00:33
 */
public class NotSitting {
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[]){
		int t = sc.nextInt();
		while(t-- > 0){
			int n = sc.nextInt(), m = sc.nextInt();
			PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();
			for(int i = 0; i < n; i++)
				for(int j = 0; j < m; j++){
					int dist = Math.max(i, n - 1 - i) + Math.max(j, m - 1 - j);
					minheap.add(dist);
				}
			while(minheap.size() > 0)
				System.out.print(minheap.remove() + " ");
			System.out.println();
		}
	}
}
