package CodeForces.practice.cr634;

import java.util.*;

/**
 * @author Syed Ali.
 * @createdAt 19/03/2021, Friday, 10:41
 */
public class ConstructTheString {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();

		while(t-->0){
			int n = scanner.nextInt();
			int a = scanner.nextInt();
			int b = scanner.nextInt();

			int aChar = 'a';
			char[] charArray = new char[b];
			for(int i=0;i<b;i++){
				charArray[i] = (char) (aChar + i);
			}

			for(int i=0;i<n;i+=b){
				for(int j=0;j<b && j+i <n ;j++){
					System.out.print(charArray[j]);
				}
			}
			System.out.println();
		}
	}
}
