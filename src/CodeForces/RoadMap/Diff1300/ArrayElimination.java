package CodeForces.RoadMap.Diff1300;

import java.util.Scanner;

/**
 * Given:
 * 		Array consisting of non-negative integers.
 *
 * Operation:
 * 		Choose k distinct array indices 1≤i1<i2<…<ik≤n.
 * 		Calculate x = (bitwise AND Operation in array values of chosen k indices ,  x=ai1 & ai2 & … & aik)
 * 		Subtract x from (array values of chosen k indices)
 *
 *
 * To Find:
 * 		Find all possible values of k, such that it's possible to make all elements of array a equal to 0
 *
 * 	Note:
 * 		It can be proven that exists at least one possible k for any array a.
 *
 * @author Syed Ali.
 * @createdAt 17/11/2021, Wednesday, 09:27
 */
public class ArrayElimination {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int tt = 0;tt<t;tt++) {
			int n = scan.nextInt();
			int[] bit = new int[32];
			int[] arr = new int[n];

			for(int i=0;i<n;i++){
				arr[i] = scan.nextInt();
			}
			for(int i = 0;i<n;i++) {
				for(int j = 0;j<32;j++) {
					int temp = (1 << (j - 1));
					int bitwiseAnd = arr[i] & temp;
					if(bitwiseAnd> 0) bit[j]++;
				}
			}
			for(int i = 1;i<=n;i++) {
				boolean possible = true;
				for(int j = 0;j<32;j++) {
					if(bit[j]%i!=0) {
						possible = false;
						break;
					}
				}
				if(possible) System.out.print(i+" ");
			}
			System.out.println();
		}
	}

}
