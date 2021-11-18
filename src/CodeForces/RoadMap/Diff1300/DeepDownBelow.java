//package CodeForces.RoadMap.Diff1300;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 20/09/2021, Monday, 22:35
 */
public class DeepDownBelow {
	private static Scanner s = new Scanner(System.in);

	private static class Cave implements Comparator<Cave>{
		Integer maxValue;
		Integer n;

		Cave(Integer maxValue, Integer n){
			this.maxValue = maxValue;
			this.n = n;
		}

		Cave(){

		}

		@Override
		public int compare(Cave a, Cave b){
			return a.maxValue - b.maxValue;
		}
	}

	private static void solve(){
	 	int n = s.nextInt();

	 	List<Cave> caves = new ArrayList<>();
	 	for(int i=0;i<n;i++){
	 		int nCaves = s.nextInt();

	 		int max = Integer.MIN_VALUE;
	 		for(int j=0;j<nCaves;j++){
	 			int temp = s.nextInt() - j;
	 			max = Math.max(max,temp + 1);
			}

	 		Cave cave = new Cave(max,nCaves);
	 		caves.add(cave);
		}

		caves.sort(new Cave());

		int ret = 0; int add = 0;
		for (Cave p : caves) {
			ret = Math.max(ret, p.maxValue - add);
			add += p.n;
		}
		System.out.println(ret);
	}

	public static void main(String[] args) {
		int t = s.nextInt();
		while (t-- > 0) {
			solve();
		}
	}
}
