package LeetCode.arrays;

public class ValidateSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i < 9;i+=3){
            for(int j=0;j < 9;j+=3){
                if(!validateSubMatrix(board, i, j)) return false;
            }
        }

        for(int i=0;i<9;i++){
            int[] freq = new int[11];
            for(int j=0;j<9;j++){
                if(board[i][j] == '.') continue;
                freq[board[i][j] - '0']++;
            }
            for(int k=1;k<=10;k++) if(freq[k] > 1) return false;
        }

        for(int i=0;i<9;i++){
            int[] freq = new int[11];
            for(int j=0;j<9;j++){
                if(board[j][i] == '.') continue;
                freq[board[j][i] - '0']++;
            }
            for(int k=1;k<=10;k++) if(freq[k] > 1) return false;
        }
        return true;
    }

    private boolean validateSubMatrix(char[][] board, int row, int col){
        int[] freq = new int[11];
        for(int i=row;i < row + 3;i++){
            for(int j=col;j< col + 3;j++){
                if(board[i][j] == '.') continue;
                freq[board[i][j] - '0']++;
            }
        }

        for(int i=1;i<=10;i++) if(freq[i] > 1) return false;
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        ValidateSudoku validateSudoku = new ValidateSudoku();
        System.out.println(validateSudoku.isValidSudoku(board));
    }
}
