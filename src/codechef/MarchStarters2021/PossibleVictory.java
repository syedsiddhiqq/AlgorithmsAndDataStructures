package codechef.MarchStarters2021;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 28/03/2021, Sunday, 16:02
 */
public class PossibleVictory {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int teamA = scanner.nextInt();
		int o = scanner.nextInt();
		int teamB = scanner.nextInt();

		int totalPossible = (20 - o) * 6 + teamB;
		if(totalPossible > teamA){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	}
}
