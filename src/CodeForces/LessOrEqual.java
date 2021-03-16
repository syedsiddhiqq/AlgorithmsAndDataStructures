package CodeForces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 11/03/2021, Thursday, 23:10
 * https://codeforces.com/contest/977/problem/C
 */
public class LessOrEqual {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();

		List<Integer> arr = new ArrayList<>();
		arr.add(1);

		for(int i=0;i<n;i++) arr.add(scanner.nextInt());
		Collections.sort(arr);

		if(k == n || arr.get(k) < arr.get(k+1)){
			System.out.println(arr.get(k));
		}else{
			System.out.println(-1);
		}
	}

}
