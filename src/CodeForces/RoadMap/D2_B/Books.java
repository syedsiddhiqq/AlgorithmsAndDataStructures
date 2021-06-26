package CodeForces.RoadMap.D2_B;

import java.util.*;

/**
 * @author Syed Ali.
 * @createdAt 08/05/2021, Saturday, 14:57
 */
public class Books {
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		int n = s.nextInt();
		int t = s.nextInt();
		int [] a = new int[n];
		for(int i=0;i<n;i++){
			a[i] = s.nextInt();
		}
		int l=0;
		int sum = 0;
		int ans = 0;
		for(int r = 0;r<n;r++){
			sum+=a[r];
			if(sum<=t){
				ans = Math.max(ans, r-l+1);
			}else{
				sum -= a[l++];
			}
		}
		System.out.println(ans);
		s.close();
	}
}
