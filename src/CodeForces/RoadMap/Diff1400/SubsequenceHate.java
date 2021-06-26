package CodeForces.RoadMap.Diff1400;

import java.util.*;
/**
 * @author Syed Ali.
 * @createdAt 11/05/2021, Tuesday, 22:41
 */
public class SubsequenceHate {
	static Scanner fs = new Scanner(System.in);

	private static void solve(){
		String str = fs.next();

		int numOfZeroes = 0,numberOfOnes = 0;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)  == '0'){
				++numOfZeroes;
			}else {
				++numberOfOnes;
			}
		}

		int ans = Math.min(numberOfOnes,numOfZeroes);

		int zeroSoFar = 0, oneSoFar = 0;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i) == '0'){
				++zeroSoFar;
			}else{
				++oneSoFar;
			}

			// check for 1111000 good strings..
			ans = Math.min(ans,(zeroSoFar + (numberOfOnes - oneSoFar)));

			// check for 000111 good strings..
			ans = Math.min(ans,(oneSoFar + (numOfZeroes - zeroSoFar)));
		}

		System.out.println(ans);
	}

	public static void main(String[] args) {
		int t = fs.nextInt();
		while(t-->0){
			solve();
		}
	}
}
