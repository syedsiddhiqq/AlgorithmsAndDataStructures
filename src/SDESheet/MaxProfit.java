package SDESheet;

/**
 * @author Syed Ali.
 * @createdAt 28/12/2021, Tuesday, 10:15
 */
public class MaxProfit {
	public static int maxProfit(int[] prices) {
		int n = prices.length;
		int[] left = new int[n];
		int[] right = new int[n];

		int minPrice = prices[0];
		left[0] = 0; right[n - 1] = 0;
		for(int i=1;i<n;i++){
			minPrice = Math.min(minPrice,prices[i]);
			left[i] = Math.max(left[i-1],prices[i] - minPrice);
		}

		int maxPrice = prices[n - 1];
		for(int i=n-2;i>=0;i--){
			maxPrice = Math.max(maxPrice,prices[i]);
			right[i] = Math.max(right[i+1],maxPrice - prices[i]);
		}

		int profit = 0;
		for(int i=1;i<n-1;i++){
			profit = Math.max(profit, left[i-1] + right[i]);
		}
		return profit;
	}

	public static void main(String[] args) {
		int[] arr = {3,3,5,0,0,3,1,4};
		System.out.println(maxProfit(arr));
	}
}
