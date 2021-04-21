package LeetCode.TopInterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @author Syed Ali.
 * @createdAt 21/04/2021, Wednesday, 19:58
 */
public class RemoveSubfolders {
	static class Solution {
		public List<String> removeSubfolders(String[] folder) {
			Arrays.sort(folder);


			List<String> result = new ArrayList<>();
//			resulta
			for(int i=0;i<folder.length;i++){
				boolean contains = false;
				int start = 1;
				StringBuilder re = new StringBuilder();;
				while(start < folder[i].length()){

					while(start < folder[i].length() && folder[i].charAt(start) != '/'){
						re.append(folder[i].charAt(start));
						++start;
					}
					++start;
					if(result.contains(re.toString())){
						contains = true;
						break;
					}
				}
				if(!contains){
					result.add(re.toString());
				}
			}
			return result;
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().removeSubfolders(new String[]{"/a/b/c", "/a/b/ca", "/a/b/d"}));
	}
}
