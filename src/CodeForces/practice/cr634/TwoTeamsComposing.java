//package CodeForces.practice.cr634;

import java.util.*;
/**
 * @author Syed Ali.
 * @createdAt 19/03/2021, Friday, 11:31
 */
public class TwoTeamsComposing {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int t = scanner.nextInt();
		while(t-->0){
			int n = scanner.nextInt();
			int[] freq = new int[200001];
			int[] arr = new int[n];
			int maxFreq = Integer.MIN_VALUE, totalKeys = 0;
			for(int i=0;i<n;i++){
				arr[i] = scanner.nextInt();
				if(freq[arr[i]] == 0) totalKeys ++;
				freq[arr[i]]++;
				if(maxFreq<freq[arr[i]]){

					maxFreq = freq[arr[i]];
				}
			}

			totalKeys = totalKeys - 1;
			int maxTeam = n/2;
			if(maxTeam>= 1){
				while(maxTeam>0){
					if(maxFreq >= maxTeam && totalKeys + (maxFreq > maxTeam ? 1 : 0) >=maxTeam){
						System.out.println(maxTeam);
						break;
					}
					maxTeam--;
				}
			}else{
				System.out.println(0);
			}
		}
	}
}
