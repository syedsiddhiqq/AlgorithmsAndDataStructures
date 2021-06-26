package CodeForces.RoadMap.Diff1400;


import java.util.*;
/**
 * @author Syed Ali.
 * @createdAt 11/05/2021, Tuesday, 23:35
 */
public class RotationMatching {
	private static Scanner fs = new Scanner(System.in);

	public static void main(String[] args) {
		int n = fs.nextInt();


		int[] a = new int[n+1];
		int[] rightShift = new int[n+1];

		for(int i=0;i<n;i++){
			int t = fs.nextInt();
			a[t] = i+1;
		}


		int answer = -1;

		// rightshifts.
		for(int i=1;i<=n;i++){
			int t = fs.nextInt();
			int shiftsRequired ;
			if(a[t] == i){
				shiftsRequired = 0;
			}else if(i > a[t]){
				shiftsRequired = (n - i - 1) + (a[t] + 1);
			}else{
				shiftsRequired = a[t] - i;
			}
			++rightShift[shiftsRequired];
			answer = Math.max(answer,rightShift[shiftsRequired]);
		}
		System.out.println(answer);
	}
}
