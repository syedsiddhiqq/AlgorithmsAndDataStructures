package volante;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Syed Ali.
 * @createdAt 13/01/2022, Thursday, 15:29
 */
public class CurrencyDenomination {

	private static int[] findDenominations(int[] arr,int target){
		int[] result = new int[2];
		result[0] = result[1] = -1;
		Map<Integer, Integer> map = new HashMap<>();

		for(int i=0;i<arr.length;i++){
			if(map.containsKey(arr[i])){
				result[0] = map.get(arr[i]);
				result[1] =  i;
				return result;
			}
			map.put(target - arr[i],i);
		}
		return result;
	}
	public static void main(String[] args) {
		int[] arr = {3,7,9,2};
		int target = 6;
		int[] op = findDenominations(arr,target);
		System.out.println(op[0] + "," + op[1]);
	}
}
