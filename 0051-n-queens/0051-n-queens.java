class Solution {

    public static boolean isSafe(char board[][], int row, int col, int n) {

        // Check same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n;
             i--, j++) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void nQueens(char board[][], int row, int n,
                               List<List<String>> ans) {

        // Base case
        if (row == n) {

            List<String> temp = new ArrayList<>();

            for (int i = 0; i < n; i++) {

                String str = "";

                for (int j = 0; j < n; j++) {
                    str += board[i][j];
                }

                temp.add(str);
            }

            ans.add(temp);
            return;
        }

        // Current row mein har column try karo
        for (int col = 0; col < n; col++) {

            if (isSafe(board, row, col, n)) {

                // Place queen
                board[row][col] = 'Q';

                // Next row
                nQueens(board, row + 1, n, ans);

                // Backtracking
                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        // Initialize board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        List<List<String>> ans = new ArrayList<>();

        nQueens(board, 0, n, ans);

        return ans;
    }
}