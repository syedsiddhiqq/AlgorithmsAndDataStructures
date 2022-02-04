package LeetCode.Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Syed Ali.
 * @createdAt 03/12/2021, Friday, 18:43
 */
public class LeastIntervalV1 {
	static class Element{
		Character key;
		Integer count;

		Element(Character key, Integer count){
			this.key = key;
			this.count = count;
		}

		Element(){

		}
	}

	public static int leastInterval(char[] tasks, int n) {
		Map<Character,Element> map = new HashMap<>();
		for(int i=0;i<tasks.length;i++){
			char ch = tasks[i];
			if(map.containsKey(ch)){
				map.get(ch).count++;
			}else{
				map.put(ch, new Element(ch,1));
			}
		}

		Queue<Element> q = new PriorityQueue<>((a, b)-> (b.count - a.count));
		q.addAll(map.values());

		int count = 0;
		while(!q.isEmpty()){
			int interval = n + 1;

			List<Element> temp = new ArrayList<>();
			while(interval > 0 && !q.isEmpty()){
				Element ele = q.poll();
				ele.count--;
				temp.add(ele);
				interval--;
				count++;
			}

			for(Element val : temp){
				if(val.count > 0){
					q.add(val);
				}
			}

			if(q.isEmpty()){
				break;
			}

			count+= interval;
		}
		return count;
	}

	public static void main(String[] args) {
		char[] arr = {'A','A','A','B','B','B'};
		leastInterval(arr,2);
	}
}
