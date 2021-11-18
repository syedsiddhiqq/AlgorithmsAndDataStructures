package CodeForces.RoadMap.Diff1300;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 28/09/2021, Tuesday, 21:36
 */
public class ProductiveMeeting {
	private static Scanner s = new Scanner(System.in);

	private static class Element implements Comparator<Element> {
		Integer id;
		Integer value;

		Element(Integer id, Integer value) {
			this.id = id;
			this.value = value;
		}

		Element() {

		}

		@Override
		public int compare(Element a, Element b) {
			return b.value - a.value;
		}
	}

	private static void solve() {
		int n = s.nextInt();
		Queue<Element> pq = new PriorityQueue<>(new Element());
		for (int i = 0; i < n; i++) {
			int temp = s.nextInt();
			pq.add(new Element(i + 1, temp));
		}

		List<String> result = new ArrayList<>();
		while (pq.size() > 1) {
			Element firstMaxEle = pq.poll();
			Element secondMaxEle = pq.poll();
			if(firstMaxEle.value > 0 && secondMaxEle.value > 0){
				result.add(firstMaxEle.id + " " + secondMaxEle.id + "\n");
				firstMaxEle.value--;
				secondMaxEle.value--;
				if (firstMaxEle.value > 0) pq.add(firstMaxEle);
				if (secondMaxEle.value > 0) pq.add(secondMaxEle);
			}
		}

		if (result.size() > 0) {
			System.out.println(result.size());
			result.forEach(System.out::print);
		} else {
			System.out.println(0);
		}
	}

	public static void main(String[] args) {
		int t = s.nextInt();
		while (t-- > 0) {
			solve();
		}
	}
}
