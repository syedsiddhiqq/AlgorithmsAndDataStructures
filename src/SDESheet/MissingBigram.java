package SDESheet;


import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 15/12/2021, Wednesday, 13:34
 */
public class MissingBigram {
	private static Scanner s = new Scanner(System.in);

	private static void solve(){
		int n = s.nextInt();

		s.nextLine();
		String inputStr = s.nextLine();

		String[] bigrams = inputStr.split(" ");

		StringBuilder op = new StringBuilder();
		if(bigrams.length == 1){
			op.append(bigrams[0]);
			op.append("a");
		}else{
			op.append(bigrams[0]);
			for(int i=1;i<bigrams.length;i++){
				if(op.charAt(op.length()-1) == bigrams[i].charAt(0)){
					op.append(bigrams[i].charAt(1));
				}else{
					op.append(bigrams[i]);
				}
			}
		}

		if(op.length() != n){
			op.append("a");
		}
		System.out.println(op.toString());
	}

	public static void main(String[] args) {
		int t = s.nextInt();
		while (t-->0){
			solve();
		}
	}
}
