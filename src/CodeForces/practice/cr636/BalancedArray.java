//package CodeForces.practice.cr636;

import java.util.*;

/**
 * @author Syed Ali.
 * @createdAt 18/03/2021, Thursday, 22:56
 */
public class BalancedArray {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();

		while(t-->0){
			int n = scanner.nextInt();
			if(n/2  % 2 !=  0){
				System.out.println("NO");
			}else{
				System.out.println("YES");
				int evenSum = 0;
				int oddSum = 0;
				int oddStart = 1;

				for(int i=2;i<=n;i+=2){
					evenSum+=i;
					System.out.print(i + " ");
				}

				for(int j=0;j<n/2-1;j++){
					System.out.print(oddStart+ " ");
					oddSum+=oddStart;
					oddStart+=2;
				}
				oddSum+=oddStart;
				if(evenSum == oddSum){
					System.out.println(oddStart);
				}else{
					while(evenSum != oddSum){
						oddSum-=oddStart;
						oddStart+=2;
						oddSum+=oddStart;
					}
					System.out.println(oddStart);
				}
			}
		}
	}
}
