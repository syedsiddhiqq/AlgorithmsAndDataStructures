package GFG;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 06/03/2021, Saturday, 15:19
 */
public class SpirallyTraverse {
	public static void main(String args[])throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while(t-- > 0)
		{
			int r = sc.nextInt();
			int c = sc.nextInt();

			int matrix[][] = new int[r][c];

			for(int i = 0; i < r; i++)
			{
				for(int j = 0; j < c; j++)
					matrix[i][j] = sc.nextInt();
			}
			SpirallyTraverseSolution ob = new SpirallyTraverseSolution();
			ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
			for (Integer val: ans)
				System.out.print(val+" ");
			System.out.println();
		}
	}
}


class SpirallyTraverseSolution{



	static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c){
		// to switch traversing between rows and cols.
		ArrayList<Integer> result = new ArrayList<>();
		int length = r*c,i = 0,j = 0;
		do {

			// traverse right
			while (j < c && j > -1 && length > 0) {
				if (matrix[i][j] != Integer.MAX_VALUE) {
					result.add(matrix[i][j]);
					matrix[i][j++] = Integer.MAX_VALUE;
					length--;
				} else {
					break;
				}
			}

			j--;
			i++;
			//traverse down
			while (i < r && j > -1 && length > 0) {
				if (matrix[i][j] != Integer.MAX_VALUE) {
					result.add(matrix[i][j]);
					matrix[i++][j] = Integer.MAX_VALUE;
					length--;
				} else {
					break;
				}
			}

			i--;
			j--;
			// traverse left
			while (j >= 0 && i>-1 && length > 0) {
				if (matrix[i][j] != Integer.MAX_VALUE) {
					result.add(matrix[i][j]);
					matrix[i][j--] = Integer.MAX_VALUE;
					length--;
				} else {
					break;
				}
			}

			j++;

			i = i - 1;
			// traverse up
			while (i >= 0 && j<c && length > 0) {
				if (matrix[i][j] != Integer.MAX_VALUE) {
					result.add(matrix[i][j]);
					matrix[i--][j] = Integer.MAX_VALUE;
					length--;
				} else {
					break;
				}
			}
			i++;
			j++;
		} while (length > 0);
		return result;
	}
}