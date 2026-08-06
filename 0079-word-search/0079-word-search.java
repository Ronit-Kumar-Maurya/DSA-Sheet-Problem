class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;//row 
        int n = board[0].length;//column

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(board, word, i,j, 0)) {
                    return true;
                }
            }
        }
        return false; 
    }

    private static boolean helper(char[][] board, String word,int i, int j, int index){
            if(index==word.length()){
                return true;
            }
            if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]!=word.charAt(index)){
                return false;
            }

            char temp = board[i][j];
            board[i][j]='#';

            boolean found =
                helper(board, word, i + 1, j, index + 1) || // Down
                helper(board, word, i - 1, j, index + 1) || // Up
                helper(board, word, i, j + 1, index + 1) || // Right
                helper(board, word, i, j - 1, index + 1);   // Left

            //backtracking
            board[i][j]=temp;
            return found;
        }
}