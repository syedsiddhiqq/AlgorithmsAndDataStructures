package CodeForces.practice.virtualcontests.div3_710;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Syed Ali.
 * @createdAt 29/03/2021, Monday, 03:33
 */
public class RestoringPermuation {
	static Scanner scanner = new Scanner(System.in);

	static int getFirst(Set<Integer> set){
		return set.stream().findFirst().get();
	}

	static void solve(){
		int n;
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = scanner.nextInt();
		}

		Set<Integer> naturalNumbers = new HashSet<>();
		for(int i=1;i<=n;i++){
			naturalNumbers.add(i);
		}
		// for minimal permutaion.
		List<Integer> minimal = new ArrayList<>();
		int currentMax = 0;
		for(int i=0;i<n;i++){
			int chosenNumber;
			if(currentMax < arr[i]) chosenNumber = arr[i];
			else chosenNumber = naturalNumbers.stream().findFirst().get();
			naturalNumbers.remove(chosenNumber);
			minimal.add(chosenNumber);
			currentMax = Math.max(currentMax,chosenNumber);
		}


		// for maximal permuation.
		List<Integer> maximal = new ArrayList<>();
		naturalNumbers = new HashSet<>();
		for(int i=1;i<=n;i++){
			naturalNumbers.add(i);
		}
		currentMax = 0;
		for(int i=0;i<n;i++){
			int chosenNumber;
			if(currentMax < arr[i]) chosenNumber = arr[i];
			Object key;
			Comparator c;
			else chosenNumber = Collections.binarySearch(naturalNumbers, key, c);
			naturalNumbers.remove(chosenNumber);
			minimal.add(chosenNumber);
			currentMax = Math.max(currentMax,chosenNumber);
		}
	}
	public static void main(String[] args) {
		int t = scanner.nextInt();
		while(t-->0){
			solve();
		}
	}
}
