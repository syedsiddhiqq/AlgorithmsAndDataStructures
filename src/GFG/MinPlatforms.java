package GFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Syed Ali.
 * @createdAt 03/12/2021, Friday, 07:51
 */
public class MinPlatforms {
	static int findPlatform(int arr[], int dep[], int n){
		int[][] trains = new int[n][2];

		for(int i=0;i<n;i++){
			trains[i][0] = arr[i];
			trains[i][1] = dep[i];
		}

		Arrays.sort(trains, (a, b)->{
			return a[0] - b[0];
		});

		List<int[]> platforms = new ArrayList<>();
		platforms.add(trains[0]);
		for(int i=1;i<n;i++){
			boolean found = false;
			for(int j=0;j<platforms.size();j++){
				int[] currTrain = platforms.get(j);
				if(currTrain[1] <=  trains[i][0]){
					found = true;
					currTrain[1] = trains[i][1];
					break;
				}
			}

			if(!found){
				platforms.add(trains[i]);
			}
		}
		return platforms.size();
	}

	public static void main(String[] args) {
		int[] arr = {900, 940, 950, 1100, 1500, 1800};
		int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
		findPlatform(arr,dep,6);
	}
}
