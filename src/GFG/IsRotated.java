package GFG;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 07/03/2021, Sunday, 19:32
 */
public class IsRotated {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t;
		t = sc.nextInt();
		String s12 = sc.nextLine();
		for(int i=0; i<t; i++){
			String s1 = sc.nextLine();
			String s2 = sc.nextLine();

			IsRotatedSolution obj = new IsRotatedSolution();

			boolean flag = obj.isRotated(s1, s2);

			if(flag == true) System.out.println("1");
			else System.out.println("0");

		}
	}
}

class IsRotatedSolution{

	/*  Function to check if two strings are rotated
	 *   str1, str2: input strings
	 */

	public static boolean isRotated(String str1, String str2){
		if(str1.length() == str2.length()){
			int length = str1.length();
			if(length < 2 && str1.equals(str2)){
				return true;
			}else{
				// clockwise..
				String clockwise = str1.substring(length-2) + str1.substring(0,length-2);
				String antiClockwise = str1.substring(2,length) + str1.substring(0,2);

				if(clockwise.equals(str2) || antiClockwise.equals(str2)){
					return true;
				}
			}
		}
		return false;
	}

}
