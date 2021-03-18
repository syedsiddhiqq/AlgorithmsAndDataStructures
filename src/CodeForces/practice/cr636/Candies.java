package CodeForces.practice.cr636;

import java.util.*;

/**
 * @author Syed Ali.
 * @createdAt 18/03/2021, Thursday, 22:21
 */
public class Candies {

	static int powerOf2(int k){
		int result = 1;
		while(k-->0){
			result = result * 2;
		}
		return result;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		while(t-- > 0){
			int n = scanner.nextInt();

			for(int k=2;k<=29;k++){
				int temp = (powerOf2(k) - 1);
				if(n % temp == 0){
					System.out.println(n/temp);
					break;
				}
			}
		}
	}
}
