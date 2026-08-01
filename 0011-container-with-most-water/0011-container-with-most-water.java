class Solution {
    public int maxArea(int[] height) {
        int maxwt = 0;

        int lp=0;
        int rp=height.length-1;

        while(lp<rp){
            int w = rp-lp;
            int ht = Math.min(height[lp], height[rp]);
            int currwt = w*ht;
            maxwt=Math.max(currwt, maxwt);
            if (height[lp] < height[rp]) {
                lp++;
            } else {
                rp--;
            }
        }
        return maxwt;

        // for (int i = 0; i < height.length; i++) {
        //     for (int j = i+1; j < height.length; j++) {
        //         int w = j-i;
        //         int ht = Math.min(height[i], height[j]);
        //         int currwt = w*ht;
        //         maxwt = Math.max(currwt, maxwt);
        //     }
        // }
        // return maxwt;
    }
}