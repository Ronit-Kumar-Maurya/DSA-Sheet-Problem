class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;//row 
        int n = matrix[0].length;//column
        int sR = 0;
        int eR = m - 1;
        int sC = 0;
        int eC = n - 1;

        while (sR <= eR && sC <= eC) {
            for (int j = sC; j <= eC; j++) {
                ans.add(matrix[sR][j]);
            }
            for (int i = sR+1; i <= eR; i++) {
                ans.add(matrix[i][eC]);
                
            }
            for (int j = eC-1; j >= sC; j--){
                if (sR == eR) {
                    break;
                }
                ans.add(matrix[eR][j]);  
            }
            
            for (int i = eR-1; i >=sR+1; i--){
                if (sC == eC) {
                    break;
                }
                ans.add(matrix[i][sC]);
            }

            sR++;
            eR--;
            sC++;
            eC--;
        }
        return ans;
    }
}