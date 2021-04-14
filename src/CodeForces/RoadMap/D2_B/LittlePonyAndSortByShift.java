package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 14/04/2021, Wednesday, 16:59
 */
public class LittlePonyAndSortByShift {
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

	public static void main(String[] args){
		int n = fs.nextInt();
		int[] arr = new int[n];
		Deque<Integer> q = new LinkedList<>();
		arr[0] = fs.nextInt();
		q.add(arr[0]);
		boolean needsSort = false;
		for(int i=1;i<n;i++){
			arr[i] = fs.nextInt();
			q.add(arr[i]);
			if(arr[i] < arr[i-1]){
				needsSort = true;
			}
		}

		if (!needsSort){
			System.out.println(0);
			return;
		}
		int answer = 0;
		while(true){
			int lastElement = q.peekLast();
			int firstElement = q.peekFirst();
			if(lastElement > firstElement){
				break;
			}else{
				q.addFirst(q.removeLast());
				++answer;
			}
		}

		List<Integer> newArr = new ArrayList<>(q);
		for(int i=1;i<n;i++){
			if(newArr.get(i) < newArr.get(i-1)){
				System.out.println(-1);
				return;
			}
		}
		System.out.println(answer);
	}
}
