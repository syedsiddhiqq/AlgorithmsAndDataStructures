package CodeForces.practice.Range1000to1200;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 13/09/2021, Monday, 23:31
 */
public class JuryMeeting {
	private static Scanner s = new Scanner(System.in);
	private static long mod = 998244353;
	private static int size = (int)Math.pow(10,5);
	private static long[] factorial = new long[size];
	private static long[] fac,facInv;


	static long fastpow(long n,long ti) {
		if (ti == 0)
			return 1l;
		if(ti%2==0) {
			long y=fastpow(n, ti/2);
			long k=y*y;
			k%=mod;
			return k;
		}
		else {
			long y=fastpow(n, ti/2);
			long k=((n*y)%mod)*y;
			k%=mod;
			return k;
		}
	}

	static long modInverse(long x) {
		return fastpow(x, mod-2);
	}


	static void preProcessNCR(int maxN) {
		//compute factorial for all numbers smaller than or equal maxN
		fac=new long[maxN+1];fac[0]=1;
		for(int i=1;i<fac.length;i++)fac[i]=(fac[i-1]*i)%mod;

		facInv=new long[fac.length];
		facInv[fac.length-1]=modInverse(fac[fac.length-1]);//modInverse(n!)
		for (int i=fac.length-2; i>=0; i--) {
			//modInverse(x!)=(x+1)/(x+1)!=(x+1)*modInverse((x+1)!)
			facInv[i]=(facInv[i+1]*(i+1))%mod;
		}
	}

	public static long ncr(int n,int r) {
		if(n<r)return 0;
		long num=factorial[n];
		long den=(facInv[n-r]*facInv[r])%mod;
		long ans=(num*den)%mod;
		return ans;
	}

	private static void solve(){
		int n = s.nextInt();
		Map<Integer, Integer> countMap = new HashMap<>();
		int firstMax = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			int temp = s.nextInt();
			if(countMap.containsKey(temp)){
				countMap.put(temp,countMap.get(temp)+1);
			}else{
				countMap.put(temp,1);
			}

			if(firstMax < temp){
				secondMax = firstMax;
				firstMax = temp;
			}
		}

		if(countMap.get(firstMax) > 1){
			System.out.println(factorial[n]);
		}else if(secondMax + 1 < firstMax){
			System.out.println(0);
		}else{

		}
	}

	public static void main(String[] args) {
		factorial[1]=1;
		factorial[0]=1;
		for(int i=2;i<size;i++){
			long f=i*factorial[i-1];
			f=f%mod;
			factorial[i]=f;
		}

		int t = s.nextInt();
		while(t-->0){
			solve();
		}
	}
}
