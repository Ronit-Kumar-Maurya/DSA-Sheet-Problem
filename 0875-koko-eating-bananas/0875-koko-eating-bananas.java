class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start=1;
        int end=0;
        
        for(int i=0; i<piles.length; i++){
            end = Math.max(end, piles[i]);
        }
        while(start<=end){
            int mid = start+(end-start)/2;
            long hours = 0;
            for(int i=0; i<piles.length; i++){
                hours += (piles[i]+mid-1)/mid;
            }
            if(hours<=h)end=mid-1;
            else start=mid+1;
        }
        return start;
    }
}