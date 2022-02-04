package SDESheet;

/**
 * @author Syed Ali.
 * @createdAt 15/12/2021, Wednesday, 10:56
 */
public class LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
		String prefix = strs[0];
		for(int index=1;index<strs.length;index++){
			int preInd = strs[index].indexOf(prefix);
			while( preInd != 0){
				prefix=prefix.substring(0,prefix.length()-1);
				preInd = strs[index].indexOf(prefix);
			}
			if("".equals(prefix)) return "";
		}
		return prefix;
	}

	public static void main(String[] args) {
		String[] strs = {"flower","flow","flight"};
		System.out.println(longestCommonPrefix(strs));
	}
}
