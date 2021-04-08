package LeetCode.TopInterviewQuestions;

/**
 * @author Syed Ali.
 * @createdAt 09/04/2021, Friday, 02:21
 */
public class StocksBuyAndSell {
	static class Solution {
		//		public int maxProfit(int[] prices) {
//			int maxProfit = 0;
//			for(int i=0;i<prices.length-1;i++){
//				int iter = i;
//				int j = i+1;
//				int profit = 0;
//				while(true){
//					if(j < prices.length && prices[j] > prices[j-1]){
//						++j;
//						continue;
//					}
//
//					profit+= prices[j-1] - prices[iter];
//					iter = j;
//					++j;
//
//					if(j >= prices.length) break;
//				}
//				maxProfit = Math.max(maxProfit,profit);
//			}
//			return maxProfit;
//		}
		public int maxProfit(int[] prices) {
			int maxprofit = 0;
			for (int i = 1; i < prices.length; i++) {
				if (prices[i] > prices[i - 1])
					maxprofit += prices[i] - prices[i - 1];
			}
			return maxprofit;
		}
	}

	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		System.out.println(new Solution().maxProfit(prices));
	}
}
