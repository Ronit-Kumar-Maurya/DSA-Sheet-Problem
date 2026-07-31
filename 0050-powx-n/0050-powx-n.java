class Solution {
    public double myPow(double x, int n) {
        long BF = n;
        double ans = 1;
        if(BF<0){
            x=1/x;
            BF=-BF;
        }
        while(BF>0){
            if(BF%2==1){
                ans*=x;
            }
            x*=x;
            BF/=2;
        }
        return ans;
    }
}