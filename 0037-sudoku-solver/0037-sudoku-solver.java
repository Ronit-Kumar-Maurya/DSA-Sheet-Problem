class Solution {

    public boolean isSafe(char[][] board, int row, int col, int i){
        char num = (char)(i + '0');
        // Column check
        for(int k = 0; k < 9; k++){
            if(board[k][col] == num){
                return false;
            }
        }
        // Row check
        for(int k = 0; k < 9; k++){
            if(board[row][k] == num){
                return false;
            }
        }
        // 3x3 box check
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for(int k = startRow; k < startRow + 3; k++){
            for(int m = startCol; m < startCol + 3; m++){
                if(board[k][m] == num){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean solver(char[][] board, int row, int col) {
        if (row == 9) {
            return true;
        }
        if (col == 9) {
            return solver(board, row + 1, 0);
        }
        if (board[row][col] == '.') {
            for (int i = 1; i <= 9; i++) {
                if (isSafe(board, row, col, i)) {
                    board[row][col] = (char)(i + '0');
                    if (solver(board, row, col + 1)) {
                        return true;
                    }
                    board[row][col] = '.';
                }
            }
            return false;
        } else {
            return solver(board, row, col + 1);
        }
    }

    public void solveSudoku(char[][] board) {
        solver(board, 0, 0);
    }
}