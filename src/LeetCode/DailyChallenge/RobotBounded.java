//package LeetCode.DailyChallenge;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author Syed Ali.
// * @createdAt 09/01/2022, Sunday, 12:53
// */
//public class RobotBounded {
//
//	private static String getKey()
//
//	public static boolean isRobotBounded(String instructions) {
//		char direction = 'R';
//		Map<String, Integer> map = new HashMap<>();
//		instructions += instructions;
//
//		int r = 0,c = 0;
//		String key = r+","+c;
//		map.put(key,1);
//		for(char ch : instructions.toCharArray()){
//			if(ch == 'G' && direction == 'U')
//				r--;
//			else if(ch == 'G' && direction == 'D')
//				r++;
//			else if(ch == 'G' && direction == 'L')
//				c--;
//			else if(ch == 'G' && direction == 'R')
//				c++;
//			else if(ch == 'L' && direction == 'R')
//				direction = 'U';
//			else if(ch == 'R' && direction == 'R')
//				direction = 'D';
//			else if(ch == 'L' && direction == 'D')
//				direction = 'R';
//			else if(ch == 'R' && direction == 'D')
//				direction = 'L';
//			else if(ch == 'L' && direction == 'L')
//				direction = 'D';
//			else if(ch == 'L' && direction == 'U')
//				direction = 'L';
//			else if(ch == 'R' && direction == 'U')
//				direction = 'R';
//			key = r+","+c;
//			if(ch == 'G' && map.containsKey(key)){
//				return true;
//			}else{
//				map.put(key,1);
//			}
//
//		}
//		return false;
//	}
//
//	public static void main(String[] args) {
//		System.out.println(isRobotBounded("GL"));
//	}
//}
