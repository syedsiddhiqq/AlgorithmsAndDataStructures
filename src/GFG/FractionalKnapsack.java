package GFG;

import java.util.Arrays;

/**
 * @author Syed Ali.
 * @createdAt 03/12/2021, Friday, 22:55
 */
public class FractionalKnapsack {

	static class Item {
		int value, weight;
		Item(int x, int y){
			this.value = x;
			this.weight = y;
		}
	}

	static double fractionalKnapsack(int W, Item arr[], int n) {
//		Arrays.sort(arr,(a, b)->{
//			double w1 = (double) a.value /a.weight;
//			double w2 = (double) b.value/b.weight;
//			return (int)( w2 - w1);
//		});

		Arrays.sort(arr,(a, b)->{
			double r1 = (double)(a.value) / (double)(a.weight);
			double r2 = (double)(b.value) / (double)(b.weight);
			if(r1 < r2) return 1;
			else if(r1 > r2) return -1;
			else return 0;
		});

		double sum = 0;
		for(int i=0;i<n && W > 0;i++){
			if(arr[i].weight <= W){
				sum += arr[i].value;
				W-=arr[i].weight;
			}else{
				double w1 = (double) arr[i].value/arr[i].weight;
				sum += W * w1;
				W = 0;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] values = {60,100,120};
		int[] weight = {10,20,30};

		Item[] items = new Item[3];
		for(int i=0;i<3;i++){
			items[i] = new Item(values[i],weight[i]);
		}


		fractionalKnapsack(50,items,3);
	}
}
