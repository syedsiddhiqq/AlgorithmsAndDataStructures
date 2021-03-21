//package CodeForces.contests.Contest1484Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * @author Syed Ali.
 * @createdAt 21/03/2021, Sunday, 19:55
 */
public class BasicDiplomacy {
	static class FastScanner {
		private BufferedReader reader;
		private StringTokenizer stt;

		public FastScanner() {
			reader = new BufferedReader(new InputStreamReader(System.in));
		}

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				return null;
			}
		}

		public String nextString() {
			while (stt == null || !stt.hasMoreTokens()) {
				stt = new StringTokenizer(nextLine());
			}
			return stt.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(nextString());
		}
	}
	static class Friend {
		List<Integer> daysAvailable;
		int totalCount = 0;
		int initialCount = 0;

		public Friend(int totalCount,List<Integer> daysAvailable) {
			this.totalCount = totalCount;
			this.initialCount = totalCount;
			this.daysAvailable = daysAvailable;
		}
	}

	public static void main(String[] args) {
		FastScanner in = new FastScanner();
		int t = in.nextInt();
		while(t-->0){
			int n = in.nextInt();
			int m = in.nextInt();
			Map<Integer,int[]> daysMap = new TreeMap<>();
			Map<Integer,Friend> friendsMap = new HashMap<>();
			for(int i=1;i<=m;i++){
				int k = in.nextInt();
				int[] availableFriends = new int[k];
				daysMap.put(i,availableFriends);
				for(int j=0;j<k;j++){
					int temp = in.nextInt();
					availableFriends[j] = temp;
					if(friendsMap.containsKey(temp)){
						friendsMap.get(temp).totalCount++;
						friendsMap.get(temp).daysAvailable.add(i);
					}else{
						List<Integer> daysAvailable = new ArrayList<>();
						daysAvailable.add(i);
						friendsMap.put(temp,new Friend(1,daysAvailable));
					}
				}
			}

			List<Integer> result = new ArrayList<>();
			Map<Integer,Integer> resultFreq= new HashMap<>();

			for (Integer day : daysMap.keySet()) {
				int max = -1;
				int maxKey = 0;
				int[] temp = daysMap.get(day);
				for (int value : temp) {
					if (max < friendsMap.get(value).totalCount && friendsMap.get(value).totalCount >= m / 2) {
						max = friendsMap.get(value).totalCount;
						maxKey = value;
					}
				}
				result.add(maxKey);
				if(resultFreq.containsKey(maxKey)){
					resultFreq.put(maxKey,resultFreq.get(maxKey)+1);
				}else{
					resultFreq.put(maxKey,1);
				}
				if(friendsMap.containsKey(maxKey))friendsMap.get(maxKey).totalCount--;
			}

			if(result.stream().anyMatch(i->resultFreq.get(i) > m/2)){
				System.out.println("NO");
			}else{
				System.out.println("YES");
				result.forEach(i->System.out.print(i+" "));
				System.out.println();
			}
		}
	}
}
