package HackerRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 21/02/2021, Sunday, 17:19
 */
public class GridSearch {

	public static Scanner scanner = new Scanner(System.in);

	public static void solve() {
		int numberOfWords, length;
		numberOfWords = scanner.nextInt();
		length = scanner.nextInt();
		List<String> arrayOfWords = new ArrayList<>();
		scanner.nextLine();
		for (int i = 0; i < numberOfWords; i++) {
			String str = scanner.nextLine();
			arrayOfWords.add(str);
		}

		int row = scanner.nextInt();
		int col = scanner.nextInt();
		scanner.nextLine();
		List<String> subGrid = new ArrayList<>();
		for (int i = 0; i < row; i++)
			subGrid.add(scanner.nextLine());

		// Looping array of words to find whether first row of
		// grid item is present.
		Optional<String> wordCheck = arrayOfWords.stream().filter(word -> word.contains(subGrid.get(0))).findFirst();
		if(wordCheck.isPresent()){
			// if present..
			Boolean isSubGridPresent = true;
			String word = wordCheck.get();
			int index = arrayOfWords.indexOf(word);
			int colIndex = word.indexOf(subGrid.get(0));
			int finalIndex = index;
			for (int j = 1; j < row; j++) {
				finalIndex = finalIndex + 1;
				if (finalIndex < length) {
					String nextWord = arrayOfWords.get(finalIndex);
					String subWord = subGrid.get(j);
					if (nextWord.contains(subWord)) {
						int indexOfNextWord = nextWord.indexOf(subWord);
						if (indexOfNextWord != colIndex) {
							System.out.println("NO");
							return;
						}
					}else{
						isSubGridPresent = false;
					}
				}
			}
			if(isSubGridPresent)
				System.out.println("YES");
			else
				System.out.println("NO");
		}else{
			System.out.println("NO");
		}
	}

	public static void main(String[] args) {

		int testCases = scanner.nextInt();
		while (testCases-- > 0) {
			solve();
		}
	}
}
