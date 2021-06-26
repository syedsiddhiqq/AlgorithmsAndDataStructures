package CodeForces.RoadMap.Diff1400;

import java.util.*;

/**
 * @author Syed Ali.
 * @createdAt 10/05/2021, Monday, 17:02
 */
public class DrazilAndFactorial {
	private static Scanner s = new Scanner(System.in);

	private static int factorial(int n) {
		return (n == 1 || n == 0) ? 1 : n * factorial(n - 1);
	}

	public static void main(String[] args) {
		int n = s.nextInt();
		String str = s.next();

		str = str.replace("0","");
		str = str.replace("1","");
		str = str.replace("4","322");
		str = str.replace("6","53");
		str = str.replace("8","7222");
		str = str.replace("9","7332");


		Character[] strArray = new Character[str.length()];
		for(int i=0;i<str.length();i++){
			strArray[i] = str.charAt(i);
		}

		Arrays.sort(strArray,Collections.reverseOrder());
		String ans = "";
		for(int i=0;i<strArray.length;i++){
			ans+= strArray[i];
		}
		System.out.println(ans);
	}
}
