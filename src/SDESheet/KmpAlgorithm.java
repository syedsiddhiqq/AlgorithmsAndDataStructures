package SDESheet;

/**
 * @author Syed Ali.
 * @createdAt 16/12/2021, Thursday, 10:58
 */
public class KmpAlgorithm {

	private static int kmpSearch(String pattern,String input){
		int n = pattern.length();
		int m = input.length();
		int[] suffixTable = new int[n];
		int i = 0,j = 1;

		while(i < n && j < n){
			if(pattern.charAt(i) == pattern.charAt(j)){
				suffixTable[j] = i+1;
				i++;
				j++;
			}else{
				if(i  != 0){
					i = suffixTable[i-1];
				}else{
					j++;
				}
			}
		}

		i = 0;j = 0;
		while(i < m){
			if(pattern.charAt(j) == input.charAt(i)){
				i++;
				j++;
			}

			if(j == n) {
				return i - n;
			}else if(pattern.charAt(j) != input.charAt(i)){
				if(j!=0){
					j = suffixTable[j-1];
				}else{
					i++;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		String pattern = "syedininput";
		String textToSearch = "searchingforsyedininput";
		boolean a = false;
		boolean b = false;
		boolean c = true;

		if(!(a || b || c)){
			System.out.println("inside if");
		}
		System.out.println();
	}
}
