package toptal;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 05/10/2021, Tuesday, 12:46
 */
public class MinRemovals {
	private static Scanner s = new Scanner(System.in);

	private static int possibleBalance(String s, Integer n){
		char[] str = s.toCharArray();
		int length = str.length;
		int plus = 0,minus = 0;
		for(int i=0;i<length;i++){
			if(str[i] == '+') ++plus;
			else ++minus;
		}

		int total = plus - minus;
		int minMoves = 0;
		if(total >= n) return 0;
		boolean resultFound = false;
		for(int i=length - 1;i>=0;i--){
			++minMoves;
			if(str[i] == '+') --plus;
			else --minus;

			total = plus - minus;
			if(total >= n){
				resultFound = true;
				break;
			}
		}
		return resultFound ? minMoves : -1;
	}
	public static void main(String[] args) {
		System.out.println(possibleBalance("++-", 2));
		System.out.println(possibleBalance("+++-++-++--+-++++-+--++-++-+-++++-+++--", 12));
		System.out.println(possibleBalance("+++-++-++--+-++++-+--++-++-+-++++-+++--", 13));
		System.out.println(possibleBalance("+++-++-++--+-++++-+--++-++-+-++++-+++--", 14));
		System.out.println(possibleBalance("+++---", 3));
		System.out.println(possibleBalance("+++-+---", 3) );
		System.out.println(possibleBalance("----+-", -2));
		System.out.println(possibleBalance("+", 10) );
		System.out.println(possibleBalance("+++-", 2));
		System.out.println(possibleBalance("+++-", 3) );
		System.out.println(possibleBalance("+++", 1) );
	}
}
