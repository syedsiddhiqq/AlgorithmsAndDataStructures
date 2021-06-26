package Zoho;

import java.util.*;

/**
 * @author Syed Ali.
 * @createdAt 23/05/2021, Sunday, 15:12
 */
public class RegexMatching {
	static Scanner fs = new Scanner(System.in);

	public static int findNext(char[] regex, int start) {
		int index = -1;
		for (int i = start; i < regex.length; i++) {
			if (regex[i] != '*' && regex[i] != 92) {
				index = i;
				break;
			}else if(regex[i] == 92 && i+1 < regex.length && regex[i+1] == '*'){
				index = i+1;
				break;
			}
		}
		return index;
	}

	public static int findNextNonSpl(char[] regex, int start) {
		int index = -1;
		for (int i = start; i < regex.length; i++) {
			if (regex[i] != '*') {
				index = i;
				break;
			}
		}
		return index;
	}

	public static boolean solve(char[] inputStr, char[] regex) {
		int start = 0;
		for (int i = 0; i < regex.length; i++) {

			// If not / or *
			// ASCII of / == 92
			if (regex[i] != '*' && regex[i] != 92 && start < inputStr.length && regex[i] != inputStr[start]) {
				boolean charFound = false;
				for (int j = start; j < inputStr.length; j++) {
					if (inputStr[j] == regex[i]) {
						charFound = true;
						start = j;
						break;
					}
				}
				if (!charFound) return false;

			} else if (regex[i] == '*') {

				// To find next non * or /
				i = findNext(regex, i + 1);
				if (i == -1) {
					return true;
				} else {
					boolean charFound = false;
					for (int j = start; j < inputStr.length; j++) {
						if (inputStr[j] == regex[i]) {
							charFound = true;
							start = j;
							break;
						}
					}
					if (!charFound) return false;
				}
			} else if (regex[i] == 92 ) {
				if (i + 1 < regex.length && regex[i + 1] == '*') {
					if(start < inputStr.length){
						if (inputStr[start] != regex[i + 1]) {
							return false;
						}
						i += 1;
					}else{
						return false;
					}
				} else {
					if (inputStr[start] != regex[i]) {
						return false;
					}
				}
			}
			++start;
		}
		return true;
	}

	public static void main(String[] args) {
		char[] inputStr = fs.next().toCharArray();
		char[] regex = fs.next().toCharArray();
		System.out.println(solve(inputStr, regex));
	}
}
