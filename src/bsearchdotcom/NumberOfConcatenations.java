package bsearchdotcom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Syed Ali.
 * @createdAt 20/03/2021, Saturday, 23:18
 */
public class NumberOfConcatenations {

	public static boolean checkFeasible(String s, String t){
		for(int i=0;i<t.length();i++){
			String str = t.charAt(i)+"";
			if(!s.contains(str)) return false;
		}
		return true;
	}

	public static int solve(String s, String t) {

		String result = "" + s;
		int count = 0;
		int start = 0;
		int prevEndOfString = 0;
		if(checkFeasible(s,t)){
			while(true){
				count++;
				int i;
				for(i=prevEndOfString;i<result.length();i++){
					if(result.charAt(i) == t.charAt(start)){
						start++;
						if(start == t.length()){
							return count;
						}
					}
				}
				prevEndOfString = i;
				result+=s;
			}
		}else{
			return -1;
		}
	}

	public static void main(String[] args) {
		System.out.println(solve("dab","abbd"));
	}
}


