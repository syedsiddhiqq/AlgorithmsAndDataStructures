package LeetCode.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Syed Ali.
 * @createdAt 28/08/2021, Saturday, 15:25
 */
public class CanIWin {
	static boolean[] states;
	public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		states = new boolean[maxChoosableInteger + 1];
		if(maxChoosableInteger >= desiredTotal) return true;
		return canIWinUtil(maxChoosableInteger,desiredTotal,new HashMap<>(),false);
	}

	public static boolean canIWinUtil(int maxChoosableInteger, int desiredTotal
			, Map<String,Boolean> memo, Boolean isA){
		System.out.println(desiredTotal);
		if(desiredTotal <= 0 && isA) return true;
		if(desiredTotal <= 0) return false;

		String key = Arrays.toString(states) + "," + isA;
		System.out.println(key);
		if(memo.containsKey(key)) return memo.get(key);

		for(int i=1;i<=maxChoosableInteger;i++){
			if(!states[i]){
				states[i] = true;
				boolean result =
						canIWinUtil(maxChoosableInteger,desiredTotal-i,memo,!isA);
				memo.put(key,result);
				states[i] = false;
			}
		}
		memo.put(key,false);
		return false;
	}

	public static void main(String[] args) {
		System.out.println(canIWin(4,6));
	}
}
