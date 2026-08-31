class Solution {

    boolean isValid(int[] quantities,int x, int shops){
        for(int product:quantities){
           shops -=(product+x-1)/x;
        }
        if(shops<0){
            return false;
        }
        return true;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int st=1;
        int end=0;
        int ans = -1;
        for(int q: quantities){
            end=Math.max(q,end);
        }
        while(st<=end){
            int mid=st+(end-st)/2;
            if(isValid(quantities,mid,n)){
                ans = mid;
                end = mid-1;
            }else{
                st=mid+1;
            }
        }
    return ans;
    }
}