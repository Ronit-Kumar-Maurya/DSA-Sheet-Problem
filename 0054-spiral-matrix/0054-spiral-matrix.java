class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;//row 
        int n = matrix[0].length;//column
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
                
            }
            right--;
            for (int i = right; i >= left; i--){
                if (top <= bottom) {
                    ans.add(matrix[bottom][i]);  
                }
            }
            bottom--;
            
            for (int i = bottom; i >= top; i--){
                if (left <= right) {
                    ans.add(matrix[i][left]);
                }
            }
            left++;
        }
        return ans;
    }
}