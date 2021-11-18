package LeetCode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Syed Ali.
 * @createdAt 20/09/2021, Monday, 18:31
 */
public class KClosestPointToOrigin {
	static class Point implements Comparator<Point> {
		int distance;
		int[] point;

		Point(int d,int[] p){
			distance = d;
			point = p;
		}

		Point(){

		}

		@Override
		public int compare(Point p1, Point p2){
			return p1.distance - p2.distance;
		}

	}

	public int distance(int x1,int x2, int y1, int y2){
		return (int)(Math.pow(x1 - x2,2) + Math.pow(y1 - y2,2));
	}


	public int[][] kClosest(int[][] points, int k) {
		int length = points.length;
		Queue<Point> q = new PriorityQueue<Point>();
		for(int i=0;i<length;i++){
			q.add(new Point(distance(0,0,points[i][0],points[i][1]),points[i]));
		}

		List<int[]> result = new ArrayList<>();
		while(k-->0){
			int[] point  = q.poll().point;
			result.add(point);
		}
		return result.toArray(new int[result.size()][]);
	}

	public static void main(String[] args) {

	}
}
