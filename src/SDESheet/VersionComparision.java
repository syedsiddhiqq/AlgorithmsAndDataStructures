package SDESheet;

/**
 * @author Syed Ali.
 * @createdAt 19/12/2021, Sunday, 14:43
 */
public class VersionComparision {
	public static int compareVersion(String version1, String version2) {
		String[] str1Versions = version1.split("\\.");
		String[] str2Versions = version2.split("\\.");


		int start = 0;
		while(start < str1Versions.length || start < str2Versions.length){
			int v1 = 0,v2 = 0;
			if(start < str1Versions.length){
				v1 = Integer.parseInt(str1Versions[start]);
			}

			if(start < str2Versions.length){
				v2 = Integer.parseInt(str2Versions[start]);
			}

			if(v1 < v2){
				return -1;
			}

			if(v1 > v2){
				return 1;
			}
			start++;
		}

		return 0;
	}

	public static void main(String[] args) {
		System.out.println(compareVersion("0.1","1.1"));
	}
}
