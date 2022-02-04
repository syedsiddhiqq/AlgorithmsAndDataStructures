package LeetCode.DailyChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * @author Syed Ali.
 * @createdAt 06/01/2022, Thursday, 19:46
 */
public class CarPooling {
	public static boolean carPooling(int[][] trips, int capacity) {
		Arrays.sort(trips,(a, b)->{
			return a[1] - b[1];
		});
		List<int[]> combined = new ArrayList<>();
		combined.add(trips[0]);

		int totalPassengers = trips[0][0];

		TreeMap<Integer, Integer> passengerMap = new TreeMap<>();
		passengerMap.put(trips[0][2], totalPassengers);

		for(int i=1;i<trips.length;i++){
			int[] previous = combined.get(combined.size() - 1);
			if(previous[2] > trips[i][1]){
				previous[0] += trips[i][0];
				previous[2] = trips[i][2];
			}else{
				combined.add(trips[i]);
			}
			// System.out.println(totalPassengers);
			Integer key = trips[i][1];
			while(key != null){
				totalPassengers -= passengerMap.get(key);
				passengerMap.remove(key);
				key = passengerMap.lowerKey(key);
			}
			if(totalPassengers + trips[i][0] > capacity) return false;
			passengerMap.put(trips[i][2],passengerMap.getOrDefault(trips[i][2],0) + trips[i][0]);
			totalPassengers += trips[i][0];
		}

		return true;
	}

	public static void main(String[] args) {
		int[][] trips = {{2,1,5},{3,5,7}};
		System.out.println(carPooling(trips,3));
	}
}
