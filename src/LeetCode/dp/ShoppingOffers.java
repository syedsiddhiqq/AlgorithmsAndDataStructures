package LeetCode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Syed Ali.
 * @createdAt 28/08/2021, Saturday, 23:35
 */
public class ShoppingOffers {
	public static Integer shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
		return shoppingOffersUtil(price, special, needs,new HashMap<>());
	}

	public static Boolean checkValid(List<Integer> needs) {
		return needs.stream().allMatch(i -> i == 0);
	}

	public static Boolean checkInvalid(List<Integer> needs) {
		return needs.stream().anyMatch(i -> i < 0);
	}

	public static String constructKey(List<Integer> needs){
		String key = "";
		for(int i=0;i<needs.size()-1;i++){
			key += needs.get(i) + ",";
		}
		key+= needs.get(needs.size()- 1);
		return key;
	}

	public static Integer shoppingOffersUtil(List<Integer> price, List<List<Integer>> special, List<Integer> needs,
											 Map<String,Integer> memo) {
		if (checkValid(needs)) return 0;
		if (checkInvalid(needs)) return Integer.MAX_VALUE;

		String key = constructKey(needs);
		System.out.println(key);
		if(memo.containsKey(key)) return memo.get(key);

		int minCost = Integer.MAX_VALUE;
		List<Integer> updatedNeeds;
		for (int i = 0; i < special.size(); i++) {
			updatedNeeds = new ArrayList<>();
			int j = 0;
			for (; j < needs.size(); j++) {
				updatedNeeds.add(needs.get(j) - special.get(i).get(j));
			}
			int result = shoppingOffersUtil(price, special, updatedNeeds,memo);
			minCost = Math.min(minCost,  result == Integer.MAX_VALUE ? Integer.MAX_VALUE : special.get(i).get(j) + result);
		}
		int cost = 0;
		for (int i = 0; i < needs.size(); i++) {
			cost += price.get(i) * needs.get(i);
		}
		minCost = Math.min(minCost, cost);
		memo.put(key,minCost);
		return minCost;
	}

	public static void main(String[] args) {
		List<Integer> price = Arrays.asList(2,3,4);
		List<List<Integer>> special = Arrays.asList(Arrays.asList(1,1,0,4),Arrays.asList(2,2,1,9));
		List<Integer> needs = Arrays.asList(1,2,1);
		System.out.println(shoppingOffers(price,special,needs));
	}
}
