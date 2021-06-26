package CodeForces.RoadMap.Diff1300;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 20/06/2021, Sunday, 16:56
 */
public class PlusAndMinus {
	private static Scanner fs = new Scanner(System.in);

	private static void solve(){
		char[] str = fs.next().toCharArray();
		int res = 0;
		for(int init = 0;init < Integer.MAX_VALUE;init++){
			int current = init;
			boolean ok = true;
			res += 1;
			for(int i=0;i<str.length;i++){
				if(str[i] == '+'){
					current += 1;
				}else{
					current -= 1;
				}

				if(current < 0){
					ok = false;
					break;
				}
			}
			if(ok){
				break;
			}
		}
		System.out.println(res);
	}

	public static void main(String[] args) {
		int t = fs.nextInt();
		while(t-->0){
			solve();
		}
	}
}
