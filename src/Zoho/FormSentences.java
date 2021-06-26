package Zoho;

import java.util.*;

/**
 * @author Syed Ali.
 * @createdAt 23/05/2021, Sunday, 17:06
 */
public class FormSentences {

	static Scanner scanner = new Scanner(System.in);

	static List<String> inputStrs = Arrays.asList("i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream",
			"icecream", "man", "go", "mango");

	/**
	 * Generate all possible substrings..
	 *
	 * @param inputStr
	 * @return
	 */
	static List<String> generateSubStrings(char[] inputStr) {
		List<String> subStrings = new ArrayList<>();
		for (int i = 0; i < inputStr.length; i++) {
			String subStr = inputStr[i] + "";
			subStrings.add(subStr);
			for (int j = i + 1; j < inputStr.length; j++) {
				subStr += inputStr[j];
				subStrings.add(subStr);
			}
		}
		return subStrings;
	}

	public static void updateFreq(int[] freq, String s) {
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch != ' ') {
				int index = ch - 'a';
				if (freq[index] > 0) {
					--freq[index];
				}
			}
		}
	}

	public static boolean checkIfWordCanBeAdded(String s, int[] freq) {
		int[] copyOfFreq = new int[27];
		for (int i = 0; i < freq.length; i++) {
			copyOfFreq[i] = freq[i];
		}

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch != ' ') {
				int index = ch - 'a';
				if (copyOfFreq[index] > 0) {
					--copyOfFreq[index];
				} else {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		char[] inputStr = scanner.next().toCharArray();
		int[] freq = new int[27];

		for (int i = 0; i < inputStr.length; i++) {
			int index = inputStr[i] - 'a';
			++freq[index];
		}


		List<String> subStrings = generateSubStrings(inputStr);
		List<String> sentences = new ArrayList<>();

		for (int i = 0; i < subStrings.size() && sentences.isEmpty(); i++) {
			if (inputStrs.contains(subStrings.get(i)) && checkIfWordCanBeAdded(subStrings.get(i), freq)) {
				String subStr = subStrings.get(i);
				updateFreq(freq, subStr);
				for (int j = i + 1; j < subStrings.size(); j++) {
					if (inputStrs.contains(subStrings.get(j)) && checkIfWordCanBeAdded(subStrings.get(j), freq)) {
						subStr += " " + subStrings.get(j);
						sentences.add(subStr);
						updateFreq(freq, subStr);
					}
				}
			}
		}

//		System.out.println(subStrings);
		System.out.println(sentences);
	}

}
