package LeetCode.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        int row = wall.size();
        Map<Integer, Integer> edgeMap = new HashMap<>();
        int result = Integer.MIN_VALUE;
        for(int i=0;i<row;i++){
            int prevBrickSize = 0;
            for(int j=0;j<wall.get(i).size();j++){
                prevBrickSize += wall.get(i).get(j);
                edgeMap.put(prevBrickSize, edgeMap.getOrDefault(prevBrickSize, 0) + 1);
                if(j != wall.get(i).size() - 1)
                result = Math.max(result, edgeMap.get(prevBrickSize));
            }
        }
        return row - 1;
    }

    public static void main(String[] args) {
        BrickWall brickWall = new BrickWall();
        int[][] wallArr = {
                {1,2,2,1},
                {3,1,2},
                {1,3,2},
                {2,4},
                {3,1,2},
                {1,3,1,1}
        };

        int[][] wallArr2 = {
                {100000000},
                {100000000},
                {100000000}
        };

        List<List<Integer>> wall = new ArrayList<>();
        for (int[] arr : wallArr) {
            List<Integer> wallRow = new ArrayList<>();
            for (int i : arr) {
                wallRow.add(i);
            }
            wall.add(wallRow);
        }

        System.out.println(brickWall.leastBricks(wall));
    }
}
