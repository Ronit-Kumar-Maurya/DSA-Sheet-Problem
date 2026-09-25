class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int[] arr= new int[nums.length];
        int n= nums.length;
        for(int i=2*n-1; i>=0; i--){
            int idx=i%n;
            while(!s.isEmpty() && nums[idx]>=nums[s.peek()]){
                s.pop();
            }
            arr[idx] = s.isEmpty()?-1: nums[s.peek()];
            s.push(idx);
        }
        return arr;
    }
}