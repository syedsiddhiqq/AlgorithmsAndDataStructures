package CodeForces.RoadMap.D2_B;

import java.util.Arrays;
import java.util.Scanner;
/**
 * @author Syed Ali.
 * @createdAt 16/04/2021, Friday, 01:40
 */
public class ProductOfThreeNumsSolution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		int a[]=new int[3];
		while(t-->0) {
			Arrays.fill(a,0);
			int cnt=0;
			int n=sc.nextInt();
			for(int i=2;i<=Math.sqrt(n);i++) {
				if(n%i==0) {
					a[cnt++]=i;
					n/=i;
					if(cnt==2) {a[cnt]=n;break;}
				}
			}
			if(cnt==2&&a[2]>a[1]) {
				System.out.println("YES\n"+a[0]+" "+a[1]+" "+a[2]);
			}
			else System.out.println("NO");
		}
		sc.close();
	}
}
