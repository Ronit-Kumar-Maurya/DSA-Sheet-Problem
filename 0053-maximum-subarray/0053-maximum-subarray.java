class Solution {
    public int maxSubArray(int[] nums) {
        int cs =0;
        int maxSum = Integer.MIN_VALUE;
        boolean allNegative = true;
        int maxElement = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>=0){
                allNegative = false;
            }
            maxElement = Math.max(maxElement, nums[i]);
        }
        if(allNegative){
            return maxElement;
        }
        for(int i=0; i<nums.length; i++){
            cs +=nums[i];
            if(cs<0){
                cs=0;
            }
            maxSum = Math.max(maxSum, cs);
        }
        return maxSum;
    }
}