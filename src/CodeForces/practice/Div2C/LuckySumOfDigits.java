//package CodeForces.practice.Div2C;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 28/03/2021, Sunday, 15:26
 */
public class LuckySumOfDigits {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num  = scan.nextInt();
		StringBuilder s = new StringBuilder();
		while(num > 0)
			if(num % 7 == 0) {
				s.append(7);
				num -= 7;
			}
			else {
				s.append(4);
				num -= 4;
			}
		System.out.println(num == 0 ? s.toString() : -1);
	}
}

