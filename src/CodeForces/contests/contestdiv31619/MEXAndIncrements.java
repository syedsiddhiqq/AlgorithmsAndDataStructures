//package CodeForces.contests.contestdiv31619;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Scanner;
//import java.util.TreeMap;
//
///**
// * @author Syed Ali.
// * @createdAt 20/12/2021, Monday, 23:59
// */
//public class MEXAndIncrements {
//	private static Scanner s = new Scanner(System.in);
//
//	private static void solve(){
//		int n = s.nextInt();
//		int[] arr = new int[n];
//
//		TreeMap<Integer, Integer> map = new TreeMap<>();
//		for(int i=0;i<n;i++){
//			arr[i] = s.nextInt();
//			if(map.containsKey(arr[i])){
//				map.put(arr[i],map.get(arr[i])+1);
//			}else{
//				map.put(arr[i],1);
//			}
//		}
//
//		int[] op = new int[n+1];
//
//		int minMex = -1;
//		int minOperationReq = 0;
//		for(int i=0;i<=n;i++){
//			int operations = 0;
//
//			if(!map.containsKey(i) && minMex == -1){
//				op[i] = 0;
//				minMex = i;
//
//			}else if(!map.containsKey(i)){
//				for(int j=0;j<minMex.size();j++){
//
//				}
//			}
//			if(map.containsKey(i)){
//				operations += map.get(i);
//			}
//
//			for(int j=0;j<)
//		}
//
//		for(int i=0;i<=n;i++){
//			System.out.print(op[i] + " ");
//		}
//	}
//
//	public static void main(String[] args) {
//		int t = s.nextInt();
//
//		while(t-->0){
//			solve();
//		}
//	}
//}
