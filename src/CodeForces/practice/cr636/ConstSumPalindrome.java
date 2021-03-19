package CodeForces.practice.cr636;

import java.util.*;

/**
 * @author Syed Ali.
 * @createdAt 19/03/2021, Friday, 02:45
 */
public class ConstSumPalindrome {
	public static void main(String[] args) {
		Scanner scanner =  new Scanner(System.in);
		int t = scanner.nextInt();

		while(t-- > 0 ){
			int n = scanner.nextInt();
			int k = scanner.nextInt();

			int[] arr = new int[n];
			for(int i=0;i<n;i++) arr[i] = scanner.nextInt();

			List<Integer> maxValues = new ArrayList<>();
			List<Integer> minValues = new ArrayList<>();

			Map<Integer, Integer> dataMap = new HashMap<>();

			for(int i=0;i<n/2;i++){
				int mx = Math.max(arr[i],arr[n-i-1]);
				int min = Math.min(arr[i],arr[n-i-1]);

				maxValues.add(mx);
				minValues.add(min);

				if(dataMap.containsKey(mx+min)){
					dataMap.put(mx+min,dataMap.get(mx+min)+1);
				}else{
					dataMap.put(mx+min,1);
				}
			}

			Collections.sort(maxValues);
			Collections.sort(minValues);

			for(int x=2;x<=2*k;x++){

			}
		}
	}
}
