package CodeForces.practice.Range800;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 12/09/2021, Sunday, 23:19
 */
public class BalancedSubstring {

	private static Scanner scanner = new Scanner(System.in);;

	private static String solve(){
		int length = scanner.nextInt();
		char[] str = scanner.next().toCharArray();
		for(int i=0;i<length-1;i++){
			if((str[i] == 'a' && str[i+1] == 'b') || (str[i] == 'b' && str[i+1] == 'a')){
				return (i+1) + " " + (i+2);
			}
		}
		return "-1 -1";
	}

	public static void main(String[] args) {
		int t = scanner.nextInt();
		for(int i=0;i<t;i++){
			System.out.println(solve());
		}
	}
}
