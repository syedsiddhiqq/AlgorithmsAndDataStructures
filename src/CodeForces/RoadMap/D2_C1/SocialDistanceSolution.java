package CodeForces.RoadMap.D2_C1;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 16/04/2021, Friday, 17:46
 */
public class SocialDistanceSolution {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
			int n=sc.nextInt();
			int k=sc.nextInt();
			String s=sc.next();
			int count=0;
			int i=0;
			while(i<n)
			{
				int temp=i;
				if(s.charAt(i)=='0')
				{
					for(int j=i;j<=i+k && j<n;j++)
					{
						if(s.charAt(j)=='1')
						{
							temp=j;
						}
					}
					if(temp==i)
					{
						count++;
					}
				}
				i = temp+k+1;
			}
			System.out.println(count);
		}
	}
}
