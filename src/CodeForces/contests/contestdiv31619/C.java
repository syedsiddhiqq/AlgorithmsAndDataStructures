package CodeForces.contests.contestdiv31619;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Syed Ali.
 * @createdAt 20/12/2021, Monday, 20:00
 */
public class C {

	private static Scanner s = new Scanner(System.in);

	private static void solve(){
		String a = s.next();
		String output = s.next();

		StringBuilder bStr = new StringBuilder();
		Stack<Character> aStack = new Stack<>();
		Stack<Character> outputStack = new Stack<>();

		for(int i=0;i<a.length();i++)
			aStack.push(a.charAt(i));


		for(int j=0;j<output.length();j++)
			outputStack.push(output.charAt(j));


		while(!aStack.isEmpty() && !outputStack.isEmpty()){
			int aValue = aStack.pop() - '0';
			int bValue = outputStack.pop() - '0';

			if(aValue > bValue && outputStack.isEmpty()) {
				System.out.println("-1");
				return;
			}

			if(aValue > bValue){
				int temp = outputStack.pop() - '0';
				if(temp != 1) {
					System.out.println("-1");
					return;
				}
				bValue =  10 + bValue;
			}

			bStr.append(String.valueOf(bValue - aValue).charAt(0));
		}

		if(!aStack.isEmpty()){
			System.out.println("-1");
			return;
		}

		while(!outputStack.isEmpty()){
			bStr.append(outputStack.pop());
		}

		bStr.reverse();
		int start = 0;
		while(start < bStr.length() && bStr.charAt(start) == '0'){
			bStr.replace(start, start+1,"");
			start++;
		}

		System.out.println(bStr);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while (t-->0) {
			List<Integer> al = new ArrayList<>();
			Map<Integer,Integer> map = new HashMap<>();
			long a = sc.nextLong();
			long s = sc.nextLong();
			List<Integer> alist = new ArrayList<>();
			List<Integer> slist = new ArrayList<>();
			long temp1 = a,temp2 = s;
			while(temp1>0) {
				alist.add(0,(int)(temp1%10));
				temp1/=10;
			}
			while(temp2>0) {
				slist.add(0,(int)(temp2%10));
				temp2/=10;
			}
//			System.out.println("alist="+alist+" slist="+slist);
			List<Integer> blist = new ArrayList<>();
			int sIndex = slist.size()-1;
			boolean flag = true;
			for (int i = alist.size()-1; i>=0; i--) {
				if(sIndex<0) {
					flag = false;
					break;
				}
				if(alist.get(i)>slist.get(sIndex)) {
					if(sIndex==0 || slist.get(sIndex-1)>1 || slist.get(sIndex-1)==0) {
						flag = false;
						break;
					}
					int diff = 10+slist.get(sIndex) - alist.get(i);
					blist.add(0,diff);
					sIndex-=2;
				}
				else {
					int diff = slist.get(sIndex) - alist.get(i);
					blist.add(0,diff);
					sIndex-=1;
				}
			}
			if(!flag) sb.append("-1\n");
			else {
				while(sIndex>=0) {
					blist.add(0,slist.get(sIndex));
					sIndex--;
				}
				StringBuilder an = new StringBuilder();
				boolean leading = true;
				for(Integer i: blist) {
					if(i!=0) leading = false;
					if(!leading) an.append(i);
				}
				if(leading) sb.append("0\n");
				else sb.append(an+"\n");
			}
		}
		System.out.println(sb);

	}
}
