package LeetCode.dp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Syed Ali.
 * @createdAt 31/08/2021, Tuesday, 07:08
 */
public class SortIntegersByPowerValue {
	public class Obj implements Comparator<Obj> {
		int key;
		int value;

		Obj(int key,int value){
			this.key = key;
			this.value = value;
		}

		Obj(){

		}

		@Override
		public int compare(Obj v1, Obj v2){
			if(v1.value < v2.value){
				return -1;
			}

			if(v1.value > v2.value){
				return 1;
			}

			return 0;
		}
	}

	public int getKth(int lo, int hi, int k) {
		List<Obj> result = new ArrayList<>();
		for(int i=lo;i<=hi;i++){
			int answer = helper(i,0);
			System.out.println(answer);
			result.add(new Obj(i,answer));
		}
		result.sort(new Obj());
		return result.get(k - 1).key;
	}

	public int helper(int i, int answer){
		if(i == 1) return 1;
		if( i % 2 == 0){
			answer += helper(i/2,1);
		}else{
			answer += helper(3 * i + 1 , 1);
		}
		return answer;
	}

	public static void main(String[] args) {
		SortIntegersByPowerValue sol = new SortIntegersByPowerValue();
		System.out.println(sol.getKth(12,15, 2));
	}
}
