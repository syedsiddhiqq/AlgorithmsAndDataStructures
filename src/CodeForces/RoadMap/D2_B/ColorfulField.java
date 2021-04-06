//package CodeForces.RoadMap.D2_B;

import java.util.Scanner;
/**
 * @author Syed Ali.
 * @createdAt 06/04/2021, Tuesday, 07:35
 */
public class ColorfulField {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int m = input.nextInt();
		int k = input.nextInt();
		int t = input.nextInt();

		int [] arr = new int[k];
		for(int i = 0; i < k; i++){
			int a = input.nextInt();
			int b = input.nextInt();
			arr[i] = b + m*(a-1);
		}



		String[] f = {"Carrots", "Kiwis", "Grapes"};
		for(int i = 0; i < t; i++){
			int x = input.nextInt();
			int y = input.nextInt();
			int num = y + m*(x-1);
			int counter = 0;
			for(int j = 0; j < k; j++){
				if(num == arr[j]){
					System.out.println("Waste");
					counter = -1;
					break;
				}
				else if(num > arr[j])
					counter++;
			}
			if(counter >= 0){
				num = num - counter -1;
				System.out.println(f[num%3]);

			}
		}


	}
}
