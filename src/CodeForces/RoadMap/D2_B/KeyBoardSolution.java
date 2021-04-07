package CodeForces.RoadMap.D2_B;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 07/04/2021, Wednesday, 00:28
 */
public class KeyBoardSolution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int x = scanner.nextInt();
		x = (int) Math.pow(x, 2);
		key[] key = new key[26];
		ArrayList<key> shifts = new ArrayList<>();
		String[] characters = new String[n];
		boolean[] alphabet = new boolean[26];
		scanner.nextLine();
		for (int i = 0; i < n; i++) {
			characters[i] = scanner.nextLine();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (characters[i].charAt(j) == 'S')
					shifts.add(new key(i, j));
				else
					key[characters[i].charAt(j) - 97] = new key(i, j);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (characters[i].charAt(j) == 'S')
					continue;
				if (!alphabet[characters[i].charAt(j) - 97] && process(i, j, x, shifts))
					alphabet[characters[i].charAt(j) - 97] = true;

			}
		}
		int count = 0;
		int q = scanner.nextInt();
		scanner.nextLine();
		String word = scanner.nextLine();
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) > 96 && word.charAt(i) < 123) {
				if (key[word.charAt(i) - 97] == null) {
					System.out.println(-1);
					return;
				}
			} else {
				if (shifts.size() == 0) {
					System.out.println(-1);
					return;
				}
				if (key[word.charAt(i) - 65] == null) {
					System.out.println(-1);
					return;
				} else {
					if (!alphabet[word.charAt(i) - 65])
						count++;
				}
			}
		}
		System.out.println(count);
	}

	public static boolean process(int i, int j, int x, ArrayList<key> shifts) {
		for (int c = 0; c < shifts.size(); c++) {
			int dist = (int) (Math.pow(Math.abs((shifts.get(c).i) - i), 2) + Math.pow(Math.abs((shifts.get(c).j) - j),
					2));
			if (dist <= x)
				return true;
		}
		return false;
	}
}

class key {
	public int i;
	public int j;

	public key(int i, int j) {
		this.i = i;
		this.j = j;
	}

	public String toString() {
		return i + " " + j;
	}
}

