package GFG;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 07/03/2021, Sunday, 02:51
 */
public class RecursivelyRemoveAdjacent {
	private static String solve(String s){
		StringBuilder str = new StringBuilder(s);
		int start = 0;
		while(true){
			int length = str.length();
			if(start < length - 1){
				if(str.charAt(start) == str.charAt(start + 1)){
					str.deleteCharAt(start+1);
					while(start+1 < str.length() && str.charAt(start) ==  str.charAt(start+1)){
						str.deleteCharAt(start+1);
					}
					str.deleteCharAt(start);
					start = start > 0 ? start - 1 : 0;
				}else{
					start++;
				}
			}else{
				break;
			}

		}
		return str.toString();
	}

	private static String removeDuplicates(String s){
		char[] stack = new char[s.length()];
		int i=0;
		for(int j=0;j<s.length();j++){
			if(i>0 && stack[i-1] == s.charAt(j)){
				i--;
			}else{
				stack[i] = s.charAt(j);
				i++;
			}
		}
		return new String(stack,0,i);
	}



	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		while(t-->0){
			String s = scanner.next();
			System.out.println(solve(s));
		}
	}
}
