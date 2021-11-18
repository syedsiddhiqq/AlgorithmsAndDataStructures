package toptal;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 05/10/2021, Tuesday, 13:09
 */
public class FindWord {

	private static Scanner s = new Scanner(System.in);

	private static void insertNextTo(StringBuilder sb,char ch,char charToInsert){
		boolean insert = false;
		int length = sb.length();
		for(int i=0;i<length;i++){
			char temp = sb.charAt(i);
			if(temp == ch && (i + 1 < length)){
				sb.setCharAt(i+1,charToInsert);
				insert = true;
				break;
			}

			if(temp == charToInsert && (i-1 > 0)){
				sb.setCharAt(i-1,ch);
				insert = true;
				break;
			}
		}

		if(!insert){
			sb.append(ch);
			sb.append(charToInsert);
		}
	}

	private static String findWord(String[] words){
		StringBuilder result = new StringBuilder();

		for(String word : words){
			String[] values = word.split(">");
			char ch = values[0].charAt(0);
			char toInsert = values[1].charAt(0);
			if(result.indexOf(ch+"") == -1 ){
				result.append(ch);
			}
			if(result.indexOf(toInsert+"") == -1 ){
				result.append(toInsert);
			}
		}

		for (String word : words) {
			String[] values = word.split(">");
			char ch = values[0].charAt(0);
			char toInsert = values[1].charAt(0);

			insertNextTo(result,ch,toInsert);
		}
		return result.toString();
	}

	public static void main(String[] args) {
		String[] input = {"I>N","A>I","P>A","S>P"};
		System.out.println(findWord(input));
	}
}
