package CodeForces;

import java.util.*;

/**
 * @author Syed Ali.
 * @createdAt 18/03/2021, Thursday, 00:40
 * https://codeforces.com/problemset/problem/352/B
 */
public class JeffAndPeriods352B {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		int[] lastValueArray = new int[100001];
		Arrays.fill(lastValueArray,-1);
		int[] differenceValueArray = new int[100001];
		Arrays.fill(differenceValueArray,-1);

		for(int i=0;i<n;i++){
			int x = scanner.nextInt();
			if(lastValueArray[x] == -1){
				lastValueArray[x] = i;
			}else{
				if(differenceValueArray[x] == -2) continue;
				if(differenceValueArray[x] == -1){
					differenceValueArray[x] = i - lastValueArray[x];
				}else{
					int currentDifference = i - lastValueArray[x];
					if(currentDifference != differenceValueArray[x]){
						differenceValueArray[x] = -2;
					}
				}
				lastValueArray[x] = i;
			}
		}

		int count = 0;
		for(int i=0;i<100000;i++){
			if(lastValueArray[i] != -1){
				if(differenceValueArray[i] != -2){
					count = count+1;
				}
			}
		}
		System.out.println(count);

		for(int i=0;i<100000;i++){
			if(lastValueArray[i] != -1){
				if(differenceValueArray[i] != -2){
					System.out.println(i + " " + ( differenceValueArray[i] == -1 ? 0 : differenceValueArray[i]));
				}
			}
		}
	}
}
