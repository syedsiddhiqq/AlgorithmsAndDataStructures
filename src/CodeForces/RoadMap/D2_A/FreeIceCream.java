package CodeForces.RoadMap.D2_A;

import java.util.Scanner;
/**
 * @author Syed Ali.
 * @createdAt 20/04/2021, Tuesday, 23:31
 */
public class FreeIceCream {
	static int n,ans,op,a;
	static long x;

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		n=in.nextInt();x=in.nextInt();
		for(int i=1;i<=n;i++)
		{
			op=in.next().charAt(0);
			a=in.nextInt();
			if(op=='+') x+=a;
			else
			{
				if(x<a) ans++;
				else x-=a;
			}
		}
		System.out.println(x+" "+ans);
	}
}
