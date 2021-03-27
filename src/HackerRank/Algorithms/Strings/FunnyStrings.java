package HackerRank.Algorithms.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Syed Ali.
 * @createdAt 27/03/2021, Saturday, 14:05
 */
public class FunnyStrings {

	static int ascii(char a){
		return a - 'a';
	}

	// Complete the funnyString function below.
	static String funnyString(String s) {
		char[] str = s.toCharArray();
		boolean notFunny = true;
		for(int i=1,j=s.length()-2;i<s.length() && j >=0;i++,j--){
			if(Math.abs(ascii(str[i]) - ascii(str[i-1])) != Math.abs(ascii(str[j]) - ascii(str[j+1]))){
				notFunny = false;
				break;
			}
		}
		return (notFunny ? "Funny" : "Not Funny");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String s = bufferedReader.readLine();
		System.out.println(funnyString(s));
	}
}
