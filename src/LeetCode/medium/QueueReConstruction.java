package LeetCode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Syed Ali.
 * @createdAt 19/09/2021, Sunday, 17:32
 */
public class QueueReConstruction {
	static class People implements Comparator<People> {
		Integer height;
		Integer smallThan;
		int[] data ;

		People(int height,int smallThan,int[] data){
			this.height = height;
			this.smallThan = smallThan;
			this.data = data;
		}

		People(){

		}

		@Override
		public int compare(People people1,People people2){
			if(people1.height < people2.height){
				return -1;
			}else if(people1.height > people2.height){
				return 1;
			}else {
				if(people1.smallThan < people2.smallThan){
					return -1;
				}else{
					return 1;
				}
			}
		}
	}
	public int[][] reconstructQueue(int[][] people) {
		List<People> pplList = new ArrayList<>();
		for(int[] p : people)
			pplList.add(new People(p[0],p[1],p));
		pplList.sort(new People());
		pplList.forEach(p->{
			System.out.println(p.height + "," + p.smallThan);
		});
		return people;
	}
}
