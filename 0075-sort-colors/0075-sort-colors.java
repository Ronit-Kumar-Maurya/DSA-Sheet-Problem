class Solution {
    public void sortColors(int[] nums) {
        // int count0 = 0;
        // int count1 = 0;
        // int count2 = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] == 0)
        //         count0++;
        //     else if (nums[i] == 1)
        //         count1++;
        //     else
        //         count2++;
        // }

        // int idx = 0;
        // for (int i = 0; i < count0; i++) {
        //     nums[idx++] = 0;
        // }
        // for (int i = 0; i < count1; i++) {
        //     nums[idx++] = 1;
        // }
        // for (int i = 0; i < count2; i++) {
        //     nums[idx++] = 2;
        // }

        //DNF algorithm

        int low =0;
        int mid =0;
        int high = nums.length-1;

        while(mid<=high){
            if(nums[mid]==0){
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                mid++;
                low++;
            }else if(nums[mid]==1){
                mid++;
            }else{
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}