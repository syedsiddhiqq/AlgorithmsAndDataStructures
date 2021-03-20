//package CodeForces.practice.Range1000to1200;

import java.util.*;

/**
 * @author Syed Ali.
 * @createdAt 20/03/2021, Saturday, 18:31
 */
public class Klcm {

	static long gcd(long a, long b){
		if(b == 0) return a;
		return gcd(b,a%b);
	}

	public static long findLcm(long[] arr){
		long answer = arr[0];

		for (int i = 1; i < arr.length; i++)
			answer = (((arr[i] * answer)) /
					(gcd(arr[i], answer)));
		return answer;
	}

	public static void main(String[] args){
		Scanner scanner =  new Scanner(System.in);
		int t = scanner.nextInt();

		while(t-->0){
			int n = scanner.nextInt();
			int k = scanner.nextInt();

			if(n % 2 != 0){
				System.out.println(1 + " " + n/2 + " " + n/2);
			}else if(n % 4 == 0){
				System.out.println(n/2 + " " + n/4 + " " + n/4);
			}else{
				System.out.println(2 + " " + (n/2 - 1) + " " + (n/2 - 1));
			}
		}
	}
}
