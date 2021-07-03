package CodeForces.RoadMap.diff1200;

import java.util.*;
/**
 * @author Syed Ali.
 * @createdAt 03/07/2021, Saturday, 12:12
 */
public class ChallengingCliffs {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for(int t=0;t<testCases;t++){
			int n = scanner.nextInt();
			long[] arr = new long[n];
			for(int i=0;i<n;i++) arr[i] = scanner.nextLong();
			Arrays.sort(arr);
			long minAbs = Integer.MAX_VALUE;
			int leftIndex = 0;
			int rightIndex = 0;
			for(int i=0;i<n-1;i++){
				long diff = Math.abs(arr[i] - arr[i+1]);
				if(minAbs > diff){
					minAbs = diff;
					leftIndex = i;
					rightIndex = i+1;
				}
			}
			System.out.print(arr[leftIndex] + " ");
			for(int j = rightIndex+1;j<n;j++){
				System.out.print(arr[j] + " ");
			}
			for(int j = 0;j<leftIndex;j++){
				System.out.print(arr[j] + " ");
			}
			System.out.println(arr[rightIndex]);
		}
	}
}
