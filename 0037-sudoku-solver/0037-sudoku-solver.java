class Solution {

    public boolean isSafe(char[][] board, int row, int col, int dig){
        char num = (char)(dig + '0');

        // Column check
        for(int i=0; i<9; i++){
            if(board[i][col] == num){
                return false;
            }
        }

        // Row check
        for(int j=0; j<9; j++){
            if(board[row][j] == num){
                return false;
            }
        }

        // 3x3 box check
        int startRow = (row/3)*3;
        int startCol = (col/3)*3;

        for(int i=startRow; i<startRow+3; i++){
            for(int j=startCol; j<startCol+3; j++){
                if(board[i][j] == num){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean solver(char[][] board, int row, int col){
        if(row==9){
            return true;
        }

        if(col==9){
            return solver(board,row+1,0);
        }

        if(board[row][col]=='.'){
            for(int dig=1; dig<=9; dig++){
                if(isSafe(board,row,col,dig)){
                    board[row][col]=(char)(dig+'0');
                    if(solver(board,row,col+1)){
                        return true;
                    }
                    board[row][col]='.';
                }
            }
            return false;
        }else{
            return solver(board,row,col+1);
        }
    }

    public void solveSudoku(char[][] board){
        solver(board,0,0);
    }
}