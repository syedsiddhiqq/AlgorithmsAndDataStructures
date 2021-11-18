package LeetCode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Syed Ali.
 * @createdAt 26/08/2021, Thursday, 20:53
 */
public class CanConstruct {

	private static boolean canConstruct(String input, List<String> arr,Map<String,Boolean> memo){
		if("".equals(input)){
			return true;
		}

		if(memo.containsKey(input)) return memo.get(input);

		for(int i=0;i<arr.size();i++){
			int index = input.indexOf(arr.get(i));
			if(index == 0 && canConstruct(input.substring(arr.get(i).length()),arr,memo)){
				memo.put(input,true);
				return true;
			}
		}
		memo.put(input,false);
		return false;
	}

	private static int canCount(String input, List<String> arr,Map<String,Integer> memo){
		if("".equals(input)){
			return 1;
		}

		if(memo.containsKey(input)) return memo.get(input);

		int answer = 0;
		for(int i=0;i<arr.size();i++){
			int index = input.indexOf(arr.get(i));
			if(index == 0){
				answer += canCount(input.substring(arr.get(i).length()),arr,memo);
			}
		}

		memo.put(input,answer);
		return answer;
	}

	public static void main(String[] args) {
//		String[] strs = {"e","ee","eee","eeee","eeeee"};
		String[] strs = {"ab","abc","cd","def","abcd","ef"};
		List<String> inputArr = Arrays.asList(strs);
		Map<String,Boolean> memo  = new HashMap<>();
		Map<String,Integer> memo1  = new HashMap<>();
//		System.out.println(canCount("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",inputArr,memo1));
		System.out.println(canCount("abcdef",inputArr,memo1));
	}
}
