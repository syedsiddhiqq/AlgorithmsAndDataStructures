package SDESheet;

/**
 * @author Syed Ali.
 * @createdAt 15/12/2021, Wednesday, 11:30
 */
public class RepeatedStringMatch {
	public static int repeatedStringMatch(String a, String b) {
		if(a.contains(b)) return 1;

		int aLength = a.length();

		// To validate whether substring b can be built from a.
		String copyOfA = a;
		while(aLength-- > 0){
			copyOfA = copyOfA.charAt(copyOfA.length() - 1) + copyOfA.substring(0,copyOfA.length() -1);
			if(!b.contains(copyOfA)){
				return -1;
			}
		}

		copyOfA = a;
		int times = 1;
		while(!copyOfA.contains(b)){
			copyOfA += a;
			times++;
		}
		return times;
	}

	public static void main(String[] args) {
		System.out.println(repeatedStringMatch("abc","cabcabca"));
	}
}
