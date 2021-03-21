//package CodeForces.practice.Range1000;

import java.util.*;

/**
 * @author Syed Ali.
 * @createdAt 21/03/2021, Sunday, 02:10
 */
public class BalancedRemainders {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		while(t-->0){
			int n = scanner.nextInt();
			int[] arr = new int[n];
			int[] freq = new int[3];
			int max = -1,min = Integer.MAX_VALUE;
			for(int i=0;i<n;i++){
				arr[i] = scanner.nextInt();
				int remainder = arr[i]%3;
				freq[remainder]++;
			}

			int operations = 0;
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					while(freq[j] > n/3){
						freq[j]--;
						freq[(j+1)%3]++;
						operations++;
					}
				}
			}
			System.out.println(operations);
		}
	}
}
