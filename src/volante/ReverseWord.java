package volante;



import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 13/01/2022, Thursday, 15:16
 */
public class ReverseWord {
	private static void reverse(char[] word){
		int i = 0,j=word.length - 1;
		while(i <= j){
			if(word[i] == '.')i++;
			if(word[j] == '.')j--;
			char temp = word[i];
			word[i] = word[j];
			word[j] = temp;
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		// Scanner s  = new Scanner(System.in);
		String str = "This is word.";
		String[] words = str.split(" ");
		for(String word : words){
			char[] wordArr = word.toCharArray();
			reverse(wordArr);
			System.out.print(new String(wordArr) + " ");
		}
	}
}
