package LeetCode.dp;

public class NinjaTraining {
    public static int ninjaTraining(int n, int points[][]) {
        int col = points[0].length;
        int result = Integer.MIN_VALUE;
        for(int i=0;i<col;i++){
            result = Math.max(result,points[0][i] + ninjaTrainingUtil(1,i, n, col, points));
        }
        return result;
    }

    private static int ninjaTrainingUtil(int i, int j, int row, int col,int[][] points){
        if(i >= row || j >= col) return 0;
        if(i  == row - 1) return points[i][j];

        int result = Integer.MIN_VALUE;
        for(int k = 0;k<col;k++){
            if( k != j){
                result = Math.max(result,points[i][j] + ninjaTrainingUtil(i + 1, k, row, col, points));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] points = {
                {1,2,5},
                {3,1,1},
                {3,3,3}
        };
        System.out.println(ninjaTraining(3, points));
    }
}
