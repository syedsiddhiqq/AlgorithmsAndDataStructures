package CodeForces.RoadMap.Diff1400;

import java.util.*;
/**
 * @author Syed Ali.
 * @createdAt 12/05/2021, Wednesday, 01:22
 */
public class PairOfTopics {
	private static Scanner fs = new Scanner(System.in);

	public static void main(String[] args) {
		int n = fs.nextInt();
		long[] a = new long[n];
		long[] b = new long[n];

		for(int i=0;i<n;i++){
			a[i] = fs.nextLong();
		}

		for(int i=0;i<n;i++){
			b[i] = fs.nextLong();
		}

		int answer = 0;
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				if(a[i] + a[j] > b[i] + b[j]){
					++answer;
				}
			}
		}
		System.out.println(answer);
	}
}
