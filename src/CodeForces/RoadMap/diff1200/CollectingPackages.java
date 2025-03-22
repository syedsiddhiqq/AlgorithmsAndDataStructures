package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 17-03-2022, Thursday, 18:36
 */
public class CollectingPackages {
    private static Scanner s = new Scanner(System.in);

    private static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static void solve(){
        int n = s.nextInt();
        Point[] packages = new Point[n];

        for(int i=0;i<n;i++){
            packages[i] = new Point(s.nextInt(),s.nextInt());
        }

        Arrays.sort(packages,(a,b)->{
            if(a.x < b.x){
                return -1;
            }else if(a.x > b.x){
                return 1;
            }else if(a.x == b.x){
                return a.y - b.y;
            }
            return 0;
        });
        collectPackages(packages);
    }

    private static void collectPackages(Point[] packages){
        Set<String> result = new HashSet<>();
        collectPackagesUtil(packages,0,0,0,"",result);
        Optional<String> path = result.stream().findFirst();
        if(path.isPresent()){
            System.out.println("YES");
            String strPath = result.stream().findFirst().get();
            System.out.println(strPath.substring(0,strPath.length()-1));
        }else{
            System.out.println("NO");
        }
    }

    private static void collectPackagesUtil(Point[] packages,int x, int y,int start,String path,Set<String> result){
        if(start == packages.length){
            result.add(path);
            return;
        }
        if(start > packages.length) return;
        if(packages[start].x < x  || packages[start].y <  y) return;
        if(x == packages[start].x && y == packages[start].y){
            // right
            collectPackagesUtil(packages,x+1,y,start+1,path+"R",result);
            // up
            collectPackagesUtil(packages,x,y+1,start+1,path+"U",result);
        }else{
            // right
            collectPackagesUtil(packages,x+1,y,start,path+"R",result);
            // up
            collectPackagesUtil(packages,x,y+1,start,path+"U",result);
        }
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while(t-->0){
            solve();
        }
    }
}
