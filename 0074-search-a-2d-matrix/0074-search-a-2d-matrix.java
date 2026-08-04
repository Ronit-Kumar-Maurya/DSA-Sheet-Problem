class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int sR=0; int eR=m-1;
        while(sR<=eR){
            int midR = sR + (eR - sR) / 2;
            if(target >= matrix[midR][0] && target <= matrix[midR][n-1]){
                int low = 0;
                int high = n-1;
                while(low<=high){
                    int mid = low+(high-low)/2;
                    if(matrix[midR][mid]==target){
                        return true;
                    }else if(matrix[midR][mid]<target){
                        low = mid+1;
                    }else{
                        high = mid-1;
                    } 
                }
                return false;
            }else if(target > matrix[midR][n-1]){
    sR = midR + 1;
}
else{
    eR = midR - 1;
}
        }
        return false;
    }
}