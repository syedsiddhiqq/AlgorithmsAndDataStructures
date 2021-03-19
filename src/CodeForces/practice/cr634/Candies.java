package CodeForces.practice.cr634;

import java.util.*;


/**
 * @author Syed Ali.
 * @createdAt 19/03/2021, Friday, 10:21
 */
public class Candies {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();

		while(t-->0){
			long n = scanner.nextLong();
			if(n < 3){
				System.out.println(0);
			}else if( n % 2 == 0){
				System.out.println(n / 2 - 1);
			}else{
				System.out.println(n/2);
			}
		}
	}
}
