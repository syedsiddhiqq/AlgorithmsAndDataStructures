package Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Syed Ali.
 * @createdAt 04/01/2022, Tuesday, 14:37
 */
public class FreqCount {

	static class Pair{
		int key;
		int count;

		Pair(int key, int count){
			this.key = key;
			this.count = count;
		}
	}


	public static void main(String[] args) {

		int[] arr = {1,2,3,2,4,5,4,4};
		Map<Integer , Pair> freqMap = new HashMap<>();

		for(int i = 0;i<arr.length;i++){
			if(freqMap.containsKey(arr[i])){
				Pair pair = freqMap.get(arr[i]);
				pair.count++;
			}else{
				freqMap.put(arr[i],new Pair(arr[i],1));
			}
		}

		List<Pair> values = new ArrayList<>(freqMap.values());

		values.sort((a,b) ->{
			return b.count - a.count;
		});


		for(Pair pair : values){
			for(int i=0;i<pair.count;i++){
				System.out.print(pair.key + " ");
			}
		}
	}
}
