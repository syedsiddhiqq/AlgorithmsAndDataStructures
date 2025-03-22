package LeetCode.medium;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 16-04-2022, Saturday, 12:26
 */
public class ValidSudoko {
    private boolean check(char[][] board, int temp, String type, int startRow, int startCol) {
        int[] freq = new int[11];

        switch (type) {
            case "ROW":
                for (int i = 0; i < 9; i++) {
                    char ch = board[temp][i];
                    if (ch == '.') continue;
                    freq[ch - '0']++;
                }
                break;
            case "COL":
                for (int i = 0; i < 9; i++) {
                    char ch = board[i][temp];
                    if (ch == '.') continue;
                    freq[ch - '0']++;
                }
                break;
            case "GRID":
                for (int i = startRow; i < startRow + 3; i++) {
                    for (int j = startCol; j < startCol + 3; j++) {
                        char ch = board[i][j];
                        if (ch == '.') continue;
                        freq[ch - '0']++;
                    }
                }
                break;
            default:
                break;
        }

        for (int i = 1; i <= 9; i++) {
            if (freq[i] > 1) return false;
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {

        // row or col check
        for (int i = 0; i < 9; i++) {
            if (!check(board, i, "ROW", 0, 0) || !check(board, i, "COL", 0, 0)) return false;
        }

        // grid check
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!check(board, i, "GRID", i, j)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
//        set.add();
    }
}
