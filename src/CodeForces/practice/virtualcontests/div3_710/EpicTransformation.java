package CodeForces.practice.virtualcontests.div3_710;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 29/03/2021, Monday, 02:02
 */
public class EpicTransformation {
	static Scanner scanner = new Scanner(System.in);

	static void solve(){
		int n = scanner.nextInt();
		int[] arr = new int[n];
		Map<Integer,Integer> freqMap = new HashMap<>();
		for(int i=0;i<n;i++){
			arr[i] = scanner.nextInt();
			if(freqMap.containsKey(arr[i])){
				freqMap.put(arr[i],freqMap.get(arr[i])+1);
			}else{
				freqMap.put(arr[i],1);
			}
		}

		Queue<Integer> pq = new PriorityQueue<>(freqMap.size(), Collections.reverseOrder());
		pq.addAll(freqMap.values());
		while(pq.size() >=2){
			Integer a = pq.poll();
			Integer b = pq.poll();
			a--;
			b--;
			if(a>0) pq.add(a);
			if(b>0) pq.add(b);
		}

		if(pq.size() == 0){
			System.out.println(0);
		}else{
			System.out.println(pq.poll());
		}
	}
	public static void main(String[] args) {
		int t = scanner.nextInt();
		while(t-->0){
			solve();
		}
	}
}
