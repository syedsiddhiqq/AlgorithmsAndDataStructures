package CodeForces.RoadMap.Diff1400;


import java.util.*;
/**
 * @author Syed Ali.
 * @createdAt 10/05/2021, Monday, 14:47
 */
public class PhoenixAndBeauty {
	static Scanner s = new Scanner(System.in);

	static void solve(){
		int n = s.nextInt();
		int k = s.nextInt();

		Set<Integer> set = new HashSet<>();
		for(int i=0;i<n;i++){
			int t = s.nextInt();
			set.add(t);
		}

		if(set.size() > k){
			System.out.print(-1);
		}else{
			System.out.println(n * k);
			for(int i=0;i<n;i++){
				set.forEach(s-> System.out.print(s + " "));
				for(int j=0;j< k - set.size();j++){
					System.out.print(1 + " ");
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int t = s.nextInt();
		while(t-->0){
			solve();
		}
	}
}
