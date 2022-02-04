package LeetCode.Greedy;

/**
 * @author Syed Ali.
 * @createdAt 24/11/2021, Wednesday, 23:18
 */
public class StockSellAndBuy {
	public static int maxProfit(int[] prices) {
		int maxCur = 0, maxSoFar = 0;
		for(int i = 1; i < prices.length; i++) {
			maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
			maxSoFar = Math.max(maxCur, maxSoFar);
		}
		return maxSoFar;
	}

	public static void main(String[] args) {
		int[] arr = {7,1,5,1,6,4};
		maxProfit(arr);
	}
}
